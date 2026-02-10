---- PERFIS ----
insert into perfil (nome) values ('Admin');
insert into perfil (nome) values ('Padrão');

---- USUARIO 1 ----
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'São Gonçalo', 'Nova Cidade', 'Rio de Janeiro', 'Rua Aquidabã', 79, 'Casa 8', 1, '24455450');

insert into login (id, matricula, senha) values (RANDOM_UUID(), 'us0001', '123');

insert into usuario (id, nome, email, cpf, ativo, data_criacao, data_atualizacao, id_perfil, id_endereco, id_login)
values ('11111111-1111-1111-1111-111111111111', 'Thiago Motta', 'thiago@fiapfood.com', '52998224725', 1, current_timestamp, null, 1,
        (SELECT id FROM endereco WHERE cidade = 'São Gonçalo'),
        (SELECT id FROM login WHERE matricula = 'us0001'));

---- USUARIO 2 ----
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Rio de Janeiro', 'Copacabana', 'RJ', 'Avenida Atlântica', 1500, 'Apto 302', 0, '22021001');

insert into login (id, matricula, senha) values (RANDOM_UUID(), 'us0002', '123');

insert into usuario (id, nome, email, cpf, ativo, data_criacao, data_atualizacao, id_perfil, id_endereco, id_login)
values ('11111111-1111-1111-1111-111111111112', 'Carla Rodrigues', 'carla.rodrigues@fiapfood.com', '16899535009', 1, current_timestamp, null, 2,
        (SELECT id FROM endereco WHERE cidade = 'Rio de Janeiro'),
        (SELECT id FROM login WHERE matricula = 'us0002'));

---- USUARIO 3 ----
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'São Paulo', 'Pinheiros', 'SP', 'Rua dos Pinheiros', 1340, 'Conjunto 25', 0, '05422002');

insert into login (id, matricula, senha) values (RANDOM_UUID(), 'us0003', '123');

insert into usuario (id, nome, email, cpf, ativo, data_criacao, data_atualizacao, id_perfil, id_endereco, id_login)
values ('11111111-1111-1111-1111-111111111113', 'Rafael Santos', 'rafael.santos@fiapfood.com', '98765432100', 0, current_timestamp, current_timestamp, 1,
        (SELECT id FROM endereco WHERE cidade = 'São Paulo'),
        (SELECT id FROM login WHERE matricula = 'us0003'));

---- USUARIO 4 ----
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Belo Horizonte', 'Savassi', 'MG', 'Rua Pernambuco', 1322, null, 0, '30130151');

insert into login (id, matricula, senha) values (RANDOM_UUID(), 'us0004', '123');

insert into usuario (id, nome, email, cpf, ativo, data_criacao, data_atualizacao, id_perfil, id_endereco, id_login)
values ('11111111-1111-1111-1111-111111111114', 'Juliana Mendes', 'juliana.mendes@fiapfood.com', '74185296340', 0, current_timestamp, current_timestamp, 2,
        (SELECT id FROM endereco WHERE cidade = 'Belo Horizonte'),
        (SELECT id FROM login WHERE matricula = 'us0004'));

---- USUARIO 5 ----
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Brasília', 'Asa Sul', 'DF', 'SQS 308', null, 'Bloco C Apto 303', 1, '70355530');

insert into login (id, matricula, senha) values (RANDOM_UUID(), 'us0005', '123');

insert into usuario (id, nome, email, cpf, ativo, data_criacao, data_atualizacao, id_perfil, id_endereco, id_login)
values ('11111111-1111-1111-1111-111111111115', 'Marcelo Alves', 'marcelo.alves@fiapfood.com', '12345678909', 1, current_timestamp, null, 1,
        (SELECT id FROM endereco WHERE cidade = 'Brasília'),
        (SELECT id FROM login WHERE matricula = 'us0005'));

---- USUARIO 6 ----
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Curitiba', 'Batel', 'PR', 'Alameda Dr. Carlos de Carvalho', 555, 'Sala 1201', 0, '80430180');

insert into login (id, matricula, senha) values (RANDOM_UUID(), 'us0006', '123');

insert into usuario (id, nome, email, cpf, ativo, data_criacao, data_atualizacao, id_perfil, id_endereco, id_login)
values ('11111111-1111-1111-1111-111111111116', 'Amanda Costa', 'amanda.costa@fiapfood.com', '39053344705', 1, current_timestamp, null, 1,
        (SELECT id FROM endereco WHERE cidade = 'Curitiba'),
        (SELECT id FROM login WHERE matricula = 'us0006'));

---- USUARIO 7 ----
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Salvador', 'Barra', 'BA', 'Avenida Oceânica', 2135, null, 0, '40140130');

insert into login (id, matricula, senha) values (RANDOM_UUID(), 'us0007', '123');

insert into usuario (id, nome, email, cpf, ativo, data_criacao, data_atualizacao, id_perfil, id_endereco, id_login)
values ('11111111-1111-1111-1111-111111111117', 'Bruno Oliveira', 'bruno.oliveira@fiapfood.com', '76251894006', 0, current_timestamp, current_timestamp, 1,
        (SELECT id FROM endereco WHERE cidade = 'Salvador'),
        (SELECT id FROM login WHERE matricula = 'us0007'));

---- USUARIO 8 ----
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Recife', 'Boa Viagem', 'PE', 'Avenida Boa Viagem', 3320, 'Apto 1802', 0, '51030300');

insert into login (id, matricula, senha) values (RANDOM_UUID(), 'us0008', '123');

insert into usuario (id, nome, email, cpf, ativo, data_criacao, data_atualizacao, id_perfil, id_endereco, id_login)
values ('11111111-1111-1111-1111-111111111118', 'Patricia Lima', 'patricia.lima@fiapfood.com', '95175348622', 0, current_timestamp, current_timestamp, 2,
        (SELECT id FROM endereco WHERE cidade = 'Recife'),
        (SELECT id FROM login WHERE matricula = 'us0008'));

---- USUARIO 9 ----
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Fortaleza', 'Meireles', 'CE', 'Avenida Beira Mar', 850, null, 0, '60165121');

insert into login (id, matricula, senha) values (RANDOM_UUID(), 'us0009', '123');

insert into usuario (id, nome, email, cpf, ativo, data_criacao, data_atualizacao, id_perfil, id_endereco, id_login)
values ('11111111-1111-1111-1111-111111111119', 'Fernando Gomes', 'fernando.gomes@fiapfood.com', '08459372030', 1, current_timestamp, null, 2,
        (SELECT id FROM endereco WHERE cidade = 'Fortaleza'),
        (SELECT id FROM login WHERE matricula = 'us0009'));

---- USUARIO 10 ----
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Porto Alegre', 'Moinhos de Vento', 'RS', 'Rua Padre Chagas', 342, 'Casa', 0, '90570080');

insert into login (id, matricula, senha) values (RANDOM_UUID(), 'us0010', '123');

insert into usuario (id, nome, email, cpf, ativo, data_criacao, data_atualizacao, id_perfil, id_endereco, id_login)
values ('11111111-1111-1111-1111-11111111111a', 'Daniela Pereira', 'daniela.pereira@fiapfood.com', '31415926501', 1, current_timestamp, null, 2,
        (SELECT id FROM endereco WHERE cidade = 'Porto Alegre'),
        (SELECT id FROM login WHERE matricula = 'us0010'));

---- USUARIO 11 ----
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Manaus', 'Adrianópolis', 'AM', 'Avenida André Araújo', null, 'Condomínio Tulipas', 1, '69057025');

insert into login (id, matricula, senha) values (RANDOM_UUID(), 'us0011', '123');

insert into usuario (id, nome, email, cpf, ativo, data_criacao, data_atualizacao, id_perfil, id_endereco, id_login)
values ('11111111-1111-1111-1111-11111111111b', 'Ricardo Souza', 'ricardo.souza@fiapfood.com', '60598732144', 0, current_timestamp, current_timestamp, 2,
        (SELECT id FROM endereco WHERE cidade = 'Manaus'),
        (SELECT id FROM login WHERE matricula = 'us0011'));

---- USUARIO 12 ----
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Florianópolis', 'Jurerê Internacional', 'SC', 'Avenida dos Búzios', 1780, 'Casa 15', 0, '88053300');

insert into login (id, matricula, senha) values (RANDOM_UUID(), 'us0012', '123');

insert into usuario (id, nome, email, cpf, ativo, data_criacao, data_atualizacao, id_perfil, id_endereco, id_login)
values ('11111111-1111-1111-1111-11111111111c', 'Luciana Ferreira', 'luciana.ferreira@fiapfood.com', '47030291855', 0, current_timestamp, current_timestamp, 2,
        (SELECT id FROM endereco WHERE cidade = 'Florianópolis'),
        (SELECT id FROM login WHERE matricula = 'us0012'));