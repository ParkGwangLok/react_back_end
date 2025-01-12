WITH RECURSIVE menu_hierarchy (
	menu_id,
	menu_name,
	parent_menu_id,
	url,
	order_index,
	LEVEL, 
	PATH, 
	cycle
) AS (
    SELECT 
        menu_id,
        menu_name,
        parent_menu_id,
        url,
        order_index,
        0 as LEVEL,
        array[order_index] as PATH,
        false as cycle
    FROM tb_menu
    WHERE parent_menu_id IS null
    UNION all
    SELECT 
        m.menu_id,
        m.menu_name,
        m.parent_menu_id,
        m.url,
        m.order_index,
		level + 1 as LEVEL,
		path || m.order_index as PATH,
		mh.order_index = any(path) as cycle
    FROM tb_menu m
    	,menu_hierarchy mh 
    where 1=1
    	and m.parent_menu_id = mh.menu_id
        and not cycle
)
select
distinct 
    lpad('', LEVEL) || menu_name AS menu_tree,
    REPEAT('  ', LEVEL) || menu_name AS menu_tree,
    url,
    path,
    order_index,
    mh.menu_id,
    parent_menu_id
FROM menu_hierarchy mh
inner join tb_role_menu trm
on mh.menu_id = trm.menu_id
where 1=1
and trm.role_id IN ('ADMIN-', 'USER')
ORDER by path, order_index
;
