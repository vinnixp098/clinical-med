create table consultas (
    id bigint not null auto_increment,
    medico varchar(100) not null,
    paciente varchar(100) not null,
    telefone_medico varchar(20) not null,
    telefone_paciente varchar(20) not null,
    data_consulta date not null,
    valor decimal(10,2) not null,
    crm varchar(20) not null,
    cpf_paciente varchar(14) not null,
    especialidade varchar(100) not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep char(9) not null,
    complemento varchar(100),
    numero varchar(10),
    uf char(2) not null,
    cidade varchar(100) not null,

    primary key (id)
);
