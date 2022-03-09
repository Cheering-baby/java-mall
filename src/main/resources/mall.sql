create table ums_menu
(
    id                   bigint not null auto_increment,
    parent_id            bigint comment '父级ID',
    create_time          datetime comment '创建时间',
    title                varchar(100) comment '菜单名称',
    level                int(4) comment '菜单级数',
    sort                 int(4) comment '菜单排序',
    name                 varchar(100) comment '前端名称',
    icon                 varchar(200) comment '前端图标',
    hidden               int(1) comment '前端隐藏',
    primary key (id)
);

create table ums_resource
(
    id                   bigint not null auto_increment,
    category_id          bigint comment '资源分类ID',
    create_time          datetime comment '创建时间',
    name                 varchar(200) comment '资源名称',
    url                  varchar(200) comment '资源URL',
    description          varchar(500) comment '描述',
    primary key (id)
);

create table ums_resource_category
(
    id                   bigint not null auto_increment,
    create_time          datetime comment '创建时间',
    name                 varchar(200) comment '分类名称',
    sort                 int(4) comment '排序',
    primary key (id)
);

create table ums_role_menu_relation
(
    id                   bigint not null auto_increment,
    role_id              bigint comment '角色ID',
    menu_id              bigint comment '菜单ID',
    primary key (id)
);

create table ums_role_resource_relation
(
    id                   bigint not null auto_increment,
    role_id              bigint comment '角色ID',
    resource_id          bigint comment '资源ID',
    primary key (id)
);

