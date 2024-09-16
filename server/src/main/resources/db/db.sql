drop database if exists innovation;
create database if not exists innovation;

use innovation;


drop table if exists users;
create table users
(
    uid       bigint unsigned auto_increment primary key comment '主键id',
    username  varchar(512) unique                             not null comment '用户名',
    name      varchar(255)        default null comment '姓名',
    password  varchar(1024)                                   not null comment '密码',
    id_card   varchar(255) unique default null comment '身份证号',
    email     varchar(255) unique default null comment '电子邮件',
    avatar    varchar(1024)       default 'defaultAvatar.png' null comment '默认头像',
    address   varchar(1024)       default null comment '地址',
    desc_text text                default null comment '个人描述',
    locked    boolean             default 0                   not null comment '是否封禁',
    enable    boolean             default 1                   not null comment '是否启用',
    create_at datetime            default current_timestamp   not null comment '创建时间',
    update_at datetime            default current_timestamp   not null on update current_timestamp comment '更新时间'
) comment '用户表';

CREATE INDEX idx_u_username ON users (username);

drop table if exists role;
create table role
(
    rid         bigint unsigned auto_increment primary key comment '主键',
    name        varchar(255)                       not null unique comment '角色名称',
    description varchar(255)                       null comment '角色描述',
    locked      boolean  default 0                 not null comment '是否封禁',
    enable      boolean  default 1                 not null comment '是否启用',
    create_at   datetime default current_timestamp not null comment '创建时间',
    update_at   datetime default current_timestamp not null on update current_timestamp comment '更新时间'
) comment '角色表';

drop table if exists students;
create table students
(
    sid            bigint unsigned auto_increment primary key comment '主键id',
    gender         bool            not null default 0 comment '性别',
    age            int             not null comment '年龄',
    cid            bigint unsigned not null comment '班级id',
    admission_date date            not null comment '入学日期',
    status         tinyint         not null default 0 comment '学生状态 0:在读 1:休学 2:退学 3:毕业 4:其他',
    uid            bigint unsigned not null comment '用户id',
    constraint fk_s_uid
        foreign key (uid) references users (uid),
    constraint fk_s_cid
        foreign key (cid) references myClass (cid)
) comment '学生表';

drop table if exists teachers;
create table teachers
(
    tid        bigint unsigned auto_increment primary key comment '主键id',
    gender     bool            not null default 0 comment '性别',
    age        int             not null comment '年龄',
    title      varchar(255)    not null default '讲师' comment '职称',
    department varchar(255)    null comment '部门',
    hire_date  date            not null comment '入职日期',
    status     tinyint         not null default 0 comment '教师状态 0:在职 1:离职 2:退休 3:其他',
    uid        bigint unsigned not null comment '用户id',
    constraint fk_t_uid
        foreign key (uid) references users (uid)
) comment '教师表';

drop table if exists myClass;
create table myClass
(
    `cid`         bigint unsigned                                NOT NULL AUTO_INCREMENT COMMENT '主键',
    `class_name`  varchar(255)                                   NOT NULL COMMENT '班级名称',
    `class_code`  varchar(255)                                   NOT NULL COMMENT '班级代码(如一班,二班)',
    `grade`       varchar(255)                                   NOT NULL COMMENT '年级',
    `major`       varchar(255)                                   NOT NULL DEFAULT '' COMMENT '专业',
    `class_size`  int unsigned                                   NULL     DEFAULT 0 COMMENT '班级人数',
    `tid`         bigint unsigned                                NOT NULL COMMENT '教师id',
    `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '班级描述',
    `school_id`   bigint UNSIGNED                                NULL     DEFAULT NULL COMMENT '学校id',
    create_at     datetime                                                default current_timestamp not null comment '创建时间',
    update_at     datetime                                                default current_timestamp not null on update current_timestamp comment '更新时间',
    PRIMARY KEY (`cid`) USING BTREE,
    INDEX `idx_c_tid_` (`tid` ASC) USING BTREE,
    CONSTRAINT `fk_c_tid` FOREIGN KEY (`tid`) REFERENCES `teachers` (`tid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) comment '班级表';

drop table if exists courses;
create table courses
(
    crid        bigint unsigned auto_increment primary key comment '主键id',
    course_name varchar(255)                       not null comment '课程名称',
    course_code varchar(255)                       not null comment '课程代码',
    credit      int                                not null comment '学分',
    description text comment '课程描述',
    create_at   datetime default current_timestamp not null comment '创建时间',
    update_at   datetime default current_timestamp not null on update current_timestamp comment '更新时间'
) comment '课程表';

drop table if exists grades;
create table grades
(
    gid       bigint unsigned auto_increment primary key comment '主键id',
    sid       bigint unsigned                    not null comment '学生id',
    crid      bigint unsigned                    not null comment '课程id',
    grade     double                             not null comment '成绩',
    create_at datetime default current_timestamp not null comment '创建时间',
    update_at datetime default current_timestamp not null on update current_timestamp comment '更新时间',
    constraint fk_g_sid
        foreign key (sid) references students (sid),
    constraint fk_g_crid
        foreign key (crid) references courses (crid)
) comment '成绩表';

drop table if exists `attendance`;
create table `attendance`
(
    aid               bigint unsigned auto_increment primary key comment '主键id',
    sid               bigint unsigned                    not null comment '学生id',
    cid               bigint unsigned                    not null comment '班级id',
    attendance_date   date                               not null comment '考勤日期',
    attendance_status tinyint                            not null comment '考勤状态 0:正常 1:迟到 2:早退 3:旷课 4:请假',
    create_at         datetime default current_timestamp not null comment '创建时间',
    update_at         datetime default current_timestamp not null on update current_timestamp comment '更新时间',
    constraint fk_a_sid
        foreign key (sid) references students (sid),
    constraint fk_a_cid
        foreign key (cid) references myClass (cid)
) comment '考勤表';

drop table if exists `family`;
create table `family`
(
    fid          bigint unsigned auto_increment primary key comment '主键id',
    sid          bigint unsigned                    not null comment '学生id',
    name         varchar(255)                       not null comment '家长姓名',
    phone        varchar(255)                       not null comment '家长电话',
    relationship varchar(255)                       not null comment '与学生关系',
    email        varchar(255)                       null comment '家长邮箱',
    address      varchar(1024)                      null comment '家庭住址',
    create_at    datetime default current_timestamp not null comment '创建时间',
    update_at    datetime default current_timestamp not null on update current_timestamp comment '更新时间',
    constraint fk_f_sid
        foreign key (sid) references students (sid)
) comment '家庭表';
drop table if exists `document`;
CREATE TABLE `document`
(
    `did`         bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '文件id',
    `uid`         bigint unsigned NOT NULL COMMENT '用户id|上传者id',
    `cid`         bigint unsigned NULL DEFAULT NULL COMMENT '班级id (如果和班级有关)',
    `tid`         bigint unsigned NULL DEFAULT NULL COMMENT '教师id (如果和教师有关)',
    `crid`        bigint unsigned NULL DEFAULT NULL COMMENT '课程id (如果和课程有关)',
    `file_name`   varchar(1024)   NULL DEFAULT NULL COMMENT '原始文件名',
    `file_path`   varchar(1024)   NULL DEFAULT NULL COMMENT '文件路径',
    `file_type`   varchar(255)    NULL DEFAULT NULL COMMENT '文件类型',
    `description` text            NULL DEFAULT NULL COMMENT '文件描述',
    `file_size`   bigint unsigned NULL DEFAULT NULL COMMENT '文件大小(单位字节)',
    `status`      tinyint         NULL DEFAULT 0 COMMENT '文件状态 0:正常 1:删除 2:禁用',
    `create_at`   datetime             default current_timestamp not null comment '创建时间',
    PRIMARY KEY (`did`),
    INDEX `idx_d_uid` (`uid` ASC),
    CONSTRAINT `fk_d_uid` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`),
    INDEX `idx_d_cid` (`cid` ASC),
    CONSTRAINT `fk_d_cid` FOREIGN KEY (`cid`) REFERENCES `myClass` (`cid`),
    INDEX `idx_d_tid` (`tid` ASC),
    CONSTRAINT `fk_d_tid` FOREIGN KEY (`tid`) REFERENCES `teachers` (`tid`),
    INDEX `idx_d_crid` (`crid` ASC),
    CONSTRAINT `fk_d_crid` FOREIGN KEY (`crid`) REFERENCES `courses` (`crid`)
) comment '文件信息';

drop table if exists `schedule`;
create table `schedule`
(
    scdid       bigint unsigned auto_increment primary key comment '主键id',
    cid         bigint unsigned                    not null comment '班级id',
    tid         bigint unsigned                    not null comment '教师id',
    crid        bigint unsigned                    not null comment '课程id',
    day_of_week tinyint                            not null comment '星期几',
    start_time  time                               not null comment '开始时间',
    end_time    time                               not null comment '结束时间',
    classroom   varchar(255)                       not null comment '教室',
    create_at   datetime default current_timestamp not null comment '创建时间',
    update_at   datetime default current_timestamp not null on update current_timestamp comment '更新时间',
    constraint fk_scd_cid
        foreign key (cid) references myClass (cid),
    constraint fk_scd_tid
        foreign key (tid) references teachers (tid),
    constraint fk_scd_crid
        foreign key (crid) references courses (crid)
) comment '课程表';

drop table if exists `events`;
create table `events`
(
    `eid`         bigint unsigned auto_increment primary key comment '主键id',
    `title`       varchar(255)    not null comment '事件标题',
    `description` text            null comment '事件描述',
    `start_time`  datetime        not null comment '开始时间',
    `end_time`    datetime        not null comment '结束时间',
    `location`    varchar(255)    null comment '地点',
    `all_day`     bool            not null default 0 comment '是否全天事件',
    `status`      tinyint         not null default 0 comment '事件状态 0:未开始 1:进行中 2:已结束',
    `created_by`  bigint unsigned not null comment '创建者id（外键，可以是教师或管理员）',
    `create_at`   datetime                 default current_timestamp not null comment '创建时间',
    `update_at`   datetime                 default current_timestamp not null on update current_timestamp comment '更新时间'
) comment '事件表';

drop table if exists `announcements`;
create table `announcements`
(
    `aid`        bigint unsigned auto_increment primary key comment '主键id',
    `title`      varchar(255)                       not null comment '公告标题',
    `content`    text                               not null comment '公告内容',
    `status`     tinyint                            not null default 0 comment '公告状态 0:未发布 1:已发布 2:已撤回 3:已删除 4:已过期 5:草稿 6:置顶 7:审核中',
    `created_by` bigint unsigned                    not null comment '创建者id（外键，可以是教师或管理员）',
    `create_at`  datetime default current_timestamp not null comment '创建时间',
    `update_at`  datetime default current_timestamp not null on update current_timestamp comment '更新时间'
) comment '公告表';

drop table if exists `exams`;
create table `exams`
(
    `eid`            bigint unsigned auto_increment primary key comment '主键id',
    `crid`           bigint unsigned                    null comment '课程id',
    `cid`            bigint unsigned                    null comment '班级id',
    `title`          varchar(255)                       not null comment '考试标题',
    `description`    text                               null comment '考试描述',
    `start_time`     datetime                           not null comment '开始时间',
    `end_time`       datetime                           not null comment '结束时间',
    `duration`       int                                not null comment '考试时长（分钟）',
    `status`         tinyint                            not null default 0 comment '考试状态 0:未开始 1:进行中 2:已结束 3:已发布 4:已撤回 5:已删除 6:已过期 7:草稿 8:审核中',
    `created_by`     bigint unsigned                    not null comment '创建者id（外键，可以是教师或管理员）',
    `classroom`      varchar(255)                       not null comment '教室',
    `invigilator_id` bigint unsigned                    null comment '监考人id',
    `create_at`      datetime default current_timestamp not null comment '创建时间',
    `update_at`      datetime default current_timestamp not null on update current_timestamp comment '更新时间'
) comment '考试表';

drop table if exists `system_logs`;
create table `system_logs`
(
    `lid`       bigint unsigned auto_increment primary key comment '主键id',
    `uid`       bigint unsigned not null comment '用户id',
    `ip`        varchar(255)    not null comment 'ip地址',
    `module`    varchar(255)    not null comment '模块',
    `action`    varchar(255)    not null comment '操作',
    `content`   text            not null comment '内容',
    `status`    tinyint         not null default 0 comment '状态 0:失败 1:成功',
    `create_at` datetime                 default current_timestamp not null comment '操作时间',
    constraint fk_sl_uid
        foreign key (uid) references users (uid)
) comment '系统日志表';

drop table if exists `disciplinary`;
create table `disciplinary`
(

    `did`        bigint unsigned auto_increment primary key comment '主键id',
    `sid`        bigint unsigned                    null comment '学生id|违纪学生id|如果存在',
    `cid`        bigint unsigned                    null comment '班级id | 违纪班级id|如果存在',
    `tid`        bigint unsigned                    null comment '教师id | 违纪教师id|如果存在',
    `reason`     text                               not null comment '违纪原因',
    `punishment` text                               not null comment '处罚措施',
    `create_at`  datetime default current_timestamp not null comment '创建时间',
    `update_at`  datetime default current_timestamp not null on update current_timestamp comment '更新时间',
    constraint fk_dis_sid
        foreign key (sid) references students (sid),
    constraint fk_dis_cid
        foreign key (cid) references myClass (cid),
    constraint fk_dis_tid
        foreign key (tid) references teachers (tid)
) comment '违纪表';

CREATE TRIGGER `before_insert_disciplinary`
    BEFORE INSERT
    ON `disciplinary`
    FOR EACH ROW
BEGIN
    IF NEW.sid IS NULL AND NEW.cid IS NULL AND NEW.tid IS NULL THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error: sid, cid, and tid cannot all be NULL';
    END IF;
END;


drop table if exists `clubs`;
create table `clubs`
(
    `clid`          bigint unsigned auto_increment primary key comment '主键id',
    `name`          varchar(255)                       not null comment '社团名称',
    `supervisor_id` bigint unsigned                    not null comment '指导老师id',
    `description`   text                               not null comment '社团描述',
    `create_at`     datetime default current_timestamp not null comment '创建时间',
    `update_at`     datetime default current_timestamp not null on update current_timestamp comment '更新时间',
    constraint fk_club_tid
        foreign key (supervisor_id) references teachers (tid)
) comment '社团表';

drop table if exists `club_members`;
create table `club_members`
(
    `cmid`      bigint unsigned auto_increment primary key comment '主键id',
    `clid`      bigint unsigned not null comment '社团id',
    `sid`       bigint unsigned not null comment '学生id',
    `role`      varchar(255)    not null comment '职位|角色',
    `status`    tinyint         not null default 0 comment '状态 0:正常 1:已退出',
    `join_date` datetime        not null default current_timestamp comment '加入日期',
    `end_date`  datetime        null     default NULL comment '退出日期',
    constraint fk_cm_cid
        foreign key (clid) references clubs (clid),
    constraint fk_cm_sid
        foreign key (sid) references students (sid)
) comment '社团成员表';


drop table if exists `physical_examination_report`;
CREATE TABLE physical_examination_report
(
    -- 主键
    report_id                     BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '体检报告ID',
    -- 基本信息
    name                          VARCHAR(100) COMMENT '受检者姓名',
    gender                        CHAR(1) COMMENT '性别 (M/F)',
    age                           INT COMMENT '年龄',
    id_card                       VARCHAR(20) COMMENT '身份证号',
    phone                         VARCHAR(20) COMMENT '联系电话',
    address                       VARCHAR(255) COMMENT '家庭住址',
    work_place                    VARCHAR(255) COMMENT '工作单位',
    date                          date default (current_date) COMMENT '体检日期',

    -- 生命体征
    height                        DECIMAL(5, 2) COMMENT '身高 (厘米)',
    weight                        DECIMAL(5, 2) COMMENT '体重 (千克)',
    systolic_BP                   INT COMMENT '收缩压',
    diastolic_BP                  INT COMMENT '舒张压',
    heart_rate                    INT COMMENT '心率',
    temperature                   DECIMAL(3, 1) COMMENT '体温 (摄氏度)',

    -- 血液检查
    WBC                           INT COMMENT '白细胞计数 (WBC)',
    RBC                           INT COMMENT '红细胞计数 (RBC)',
    HGB                           DECIMAL(5, 2) COMMENT '血红蛋白 (HGB)',
    PLT                           INT COMMENT '血小板计数 (PLT)',
    blood_type                    VARCHAR(5) COMMENT '血型 (ABO/Rh)',
    CHOL                          DECIMAL(5, 2) COMMENT '总胆固醇 (CHOL)',
    TG                            DECIMAL(5, 2) COMMENT '甘油三酯 (TG)',
    HDL_C                         DECIMAL(5, 2) COMMENT '高密度脂蛋白胆固醇 (HDL-C)',
    LDL_C                         DECIMAL(5, 2) COMMENT '低密度脂蛋白胆固醇 (LDL-C)',
    GLU                           DECIMAL(5, 2) COMMENT '血糖 (GLU)',
    ALT                           DECIMAL(5, 2) COMMENT '肝功能 - 谷丙转氨酶 (ALT)',
    AST                           DECIMAL(5, 2) COMMENT '肝功能 - 谷草转氨酶 (AST)',
    CREA                          DECIMAL(5, 2) COMMENT '肾功能 - 肌酐 (CREA)',
    UREA                          DECIMAL(5, 2) COMMENT '肾功能 - 尿素 (UREA)',
    BUN                           DECIMAL(5, 2) COMMENT '肾功能 - 血尿素氮 (BUN)',

    -- 尿液检查
    urine_protein                 VARCHAR(20) COMMENT '尿蛋白',
    urine_glucose                 VARCHAR(20) COMMENT '尿糖',
    urine_ketones                 VARCHAR(20) COMMENT '尿酮体',
    urine_occult_blood            VARCHAR(20) COMMENT '尿潜血',
    urine_WBC                     VARCHAR(20) COMMENT '尿白细胞',

    -- 影像学检查
    chest_x_ray                   TEXT COMMENT '胸部X光',
    ultrasound                    TEXT COMMENT 'B超 (肝、胆、胰、脾、肾等)',
    ECG                           TEXT COMMENT '心电图 (ECG)',

    -- 内科检查
    heart                         TEXT COMMENT '心脏检查',
    lung                          TEXT COMMENT '肺部检查',
    abdomen                       TEXT COMMENT '腹部检查',
    cerebralVessels               TEXT COMMENT '脑血管检查',

    -- 外科检查
    skin                          TEXT COMMENT '皮肤检查',
    lymph_nodes                   TEXT COMMENT '淋巴结检查',
    musculo_skeletal              TEXT COMMENT '肌肉骨骼检查',
    nervous_system                TEXT COMMENT '神经系统检查',

    -- 妇科检查 (女性)
    breast                        TEXT COMMENT '乳腺检查',
    pap_smear                     TEXT COMMENT '宫颈涂片 (Pap smear)',

    -- 眼科检查
    vision                        TEXT COMMENT '视力检查',
    conjunctiva                   TEXT COMMENT '结膜检查',
    cornea                        TEXT COMMENT '角膜检查',
    pupil                         TEXT COMMENT '瞳孔检查',
    lens                          TEXT COMMENT '晶状体检查',

    -- 耳鼻喉科检查
    hearing                       TEXT COMMENT '听力检查',
    nose                          TEXT COMMENT '鼻检查',
    throat                        TEXT COMMENT '喉检查',

    -- 口腔科检查
    teeth                         TEXT COMMENT '牙齿检查',
    oralMucosa                    TEXT COMMENT '口腔黏膜检查',

    -- 其他
    examinationConclusion         TEXT COMMENT '体检结论',
    healthGuidance                TEXT COMMENT '健康指导',
    doctorsAdvice                 TEXT COMMENT '医生建议',
    nextExaminationRecommendation TEXT COMMENT '下次体检建议'
);

drop table if exists `healthes`;
create table `healthes`
(
    `hid`            bigint unsigned auto_increment primary key comment '主键id',
    `uid`            bigint unsigned not null comment '用户id',
    `report_id`      bigint unsigned null comment '体检报告id',
    `temperature`    double          null comment '体温',
    `symptom`        text            null comment '症状',
    `height`         double          null comment '身高',
    `weight`         double          null comment '体重',
    `blood_pressure` varchar(255)    null comment '血压',
    `date`           date            not null default (year(CURDATE())) comment '日期',
    `remark`         text            null comment '备注',
    `status`         tinyint         not null default 0 comment '状态 0:正常 1:异常',
    `create_at`      datetime                 default current_timestamp not null comment '创建时间',
    `update_at`      datetime                 default current_timestamp not null on update current_timestamp comment '更新时间',
    constraint fk_h_sid
        foreign key (uid) references users (uid),
    constraint fk_h_rid
        foreign key (report_id) references physical_examination_report (report_id)
) comment '健康表';

drop table if exists user_roles;
create table user_roles
(
    user_id bigint unsigned comment '外键用户id',
    role_id bigint unsigned comment '外键角色id',
    constraint fk_ur_uid
        foreign key (user_id) references `users` (uid),
    constraint fk_ur_rid
        foreign key (role_id) references `role` (rid)
);

drop function if exists generate_unique_username;
create function generate_unique_username() returns varchar(255)
    deterministic
BEGIN
    #Routine body goes here...
    DECLARE random_string VARCHAR(12);
    DECLARE unique_username VARCHAR(255);

    SET random_string = SUBSTRING(MD5(RAND()), 1, 12);
    SET unique_username = CONCAT('innov_', random_string, '_', LAST_INSERT_ID());

    -- 检查生成的用户名是否已存在，如果存在，则递归调用函数重新生成
    IF EXISTS(SELECT 1 FROM users WHERE username = unique_username) THEN
        SET unique_username = generate_unique_username();
    END IF;
    RETURN unique_username;
END;

drop trigger if exists set_default_username;
create trigger set_default_username
    before insert
    on users
    for each row
begin
    if NEW.username is null or NEW.username = '' then
        SET NEW.username = generate_unique_username();
    end if;
end;


