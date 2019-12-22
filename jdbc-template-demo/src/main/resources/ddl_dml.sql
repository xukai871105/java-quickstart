create table countries
(
	id bigserial not null
		constraint countries_pkey
			primary key,
	name varchar(128) not null,
	country_name varchar(128) not null,
	country_code varchar(128) not null
);

comment on table countries is '国家信息';

alter table countries owner to postgres;

INSERT INTO public.countries (id, name, country_name, country_code) VALUES (1, '中国', 'China', 'CN');
INSERT INTO public.countries (id, name, country_name, country_code) VALUES (2, '香港', 'Hong Kong', 'HK');
INSERT INTO public.countries (id, name, country_name, country_code) VALUES (3, '澳门', 'Macau', 'MO');

