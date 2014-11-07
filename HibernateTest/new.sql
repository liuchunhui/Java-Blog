
    alter table address_inf 
        drop 
        foreign key FK_c0hknwq4lgw2p54yyplt9mphu

    alter table school_inf 
        drop 
        foreign key FK_768lberfq02fmf0agpfw7pgwk

    alter table score_inf 
        drop 
        foreign key FK_5opbjg1uxpxke63qqoj9u9959

    drop table if exists address_inf

    drop table if exists persons_inf

    drop table if exists school_inf

    drop table if exists score_inf

    drop table if exists hibernate_unique_key

    create table address_inf (
        person_id integer not null,
        address_name varchar(255) not null,
        primary key (person_id, address_name)
    ) ENGINE=InnoDB

    create table persons_inf (
        person_id integer not null,
        birth time,
        person_name varchar(50),
        pic longblob,
        primary key (person_id)
    ) ENGINE=InnoDB

    create table school_inf (
        person_id integer not null,
        school_name varchar(255),
        list_order integer not null,
        primary key (person_id, list_order)
    ) ENGINE=InnoDB

    create table score_inf (
        person_id integer not null,
        mark float,
        subject_name varchar(255) not null,
        primary key (person_id, subject_name)
    ) ENGINE=InnoDB

    alter table address_inf 
        add index FK_c0hknwq4lgw2p54yyplt9mphu (person_id), 
        add constraint FK_c0hknwq4lgw2p54yyplt9mphu 
        foreign key (person_id) 
        references persons_inf (person_id)

    alter table school_inf 
        add index FK_768lberfq02fmf0agpfw7pgwk (person_id), 
        add constraint FK_768lberfq02fmf0agpfw7pgwk 
        foreign key (person_id) 
        references persons_inf (person_id)

    alter table score_inf 
        add index FK_5opbjg1uxpxke63qqoj9u9959 (person_id), 
        add constraint FK_5opbjg1uxpxke63qqoj9u9959 
        foreign key (person_id) 
        references persons_inf (person_id)

    create table hibernate_unique_key (
         next_hi integer 
    )

    insert into hibernate_unique_key values ( 0 )
