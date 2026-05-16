--
-- PostgreSQL database cluster dump
--

-- Started on 2026-05-15 21:39:33

\restrict aQUfAATWfooBcvs7CnAo99R8vMoRSOzcvONGtHDURINrI3FoUpeDwIxwEBojOqQ

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'SCRAM-SHA-256$4096:RLS5bOsuiLajCLkBqyA3ag==$0eE0ka0GoMEAQ3z+c6sxDBlEr7aYfnLYSXpce5ACc9E=:PsqTCG4S+JN5wVqylt5mfatpQwGr1cl2I2E2+6wBxaU=';

--
-- User Configurations
--








\unrestrict aQUfAATWfooBcvs7CnAo99R8vMoRSOzcvONGtHDURINrI3FoUpeDwIxwEBojOqQ

--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

\restrict f6hdRaj9hB9NjroFirpz0tR3WJCpmbrury1w9I2m3ewTTjZIkYBvoTrfDpXe4x9

-- Dumped from database version 18.3
-- Dumped by pg_dump version 18.3

-- Started on 2026-05-15 21:39:33

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2026-05-15 21:39:34

--
-- PostgreSQL database dump complete
--

\unrestrict f6hdRaj9hB9NjroFirpz0tR3WJCpmbrury1w9I2m3ewTTjZIkYBvoTrfDpXe4x9

--
-- Database "postgres" dump
--

\connect postgres

--
-- PostgreSQL database dump
--

\restrict z18WSad46KosdBPaLGh62iWClBX4d0CGug2lTppOTD69xnVmXoR2cwmgCHA9X8X

-- Dumped from database version 18.3
-- Dumped by pg_dump version 18.3

-- Started on 2026-05-15 21:39:34

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2026-05-15 21:39:35

--
-- PostgreSQL database dump complete
--

\unrestrict z18WSad46KosdBPaLGh62iWClBX4d0CGug2lTppOTD69xnVmXoR2cwmgCHA9X8X

--
-- Database "usuarios" dump
--

--
-- PostgreSQL database dump
--

\restrict xHBblqkZNoI15yVOsrOK4ym4wM4NeDbAFB6Udf62HihfSUrZzffnV1YmfKPaX8g

-- Dumped from database version 18.3
-- Dumped by pg_dump version 18.3

-- Started on 2026-05-15 21:39:35

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5047 (class 1262 OID 16387)
-- Name: usuarios; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE usuarios WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';


ALTER DATABASE usuarios OWNER TO postgres;

\unrestrict xHBblqkZNoI15yVOsrOK4ym4wM4NeDbAFB6Udf62HihfSUrZzffnV1YmfKPaX8g
\connect usuarios
\restrict xHBblqkZNoI15yVOsrOK4ym4wM4NeDbAFB6Udf62HihfSUrZzffnV1YmfKPaX8g

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 224 (class 1259 OID 16584)
-- Name: tbaterror_legal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tbaterror_legal (
    filme character varying
);


ALTER TABLE public.tbaterror_legal OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16412)
-- Name: tbfavoritos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tbfavoritos (
    email character varying CONSTRAINT tbavoritos_email_not_null NOT NULL,
    filme character varying CONSTRAINT tbavoritos_filme_not_null NOT NULL
);


ALTER TABLE public.tbfavoritos OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16398)
-- Name: tbfilmes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tbfilmes (
    titulo character varying NOT NULL,
    descricao character varying,
    genero character varying NOT NULL,
    horas integer DEFAULT 0,
    minutos integer DEFAULT 0,
    segundos integer DEFAULT 0,
    avaliacoes double precision DEFAULT 0,
    "nAvaliacoes" integer DEFAULT 0
);


ALTER TABLE public.tbfilmes OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16419)
-- Name: tblistas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tblistas (
    email character varying NOT NULL,
    nome character varying
);


ALTER TABLE public.tblistas OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16559)
-- Name: tblucasdaofilmes_legais; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tblucasdaofilmes_legais (
    filme character varying
);


ALTER TABLE public.tblucasdaofilmes_legais OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16603)
-- Name: tbmateusayjindaosayjin; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tbmateusayjindaosayjin (
    filme character varying
);


ALTER TABLE public.tbmateusayjindaosayjin OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16388)
-- Name: tbusuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tbusuarios (
    email character varying NOT NULL,
    nome character varying NOT NULL,
    senha character varying NOT NULL
);


ALTER TABLE public.tbusuarios OWNER TO postgres;

--
-- TOC entry 5040 (class 0 OID 16584)
-- Dependencies: 224
-- Data for Name: tbaterror_legal; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tbaterror_legal VALUES ('teste 3: O teste verdadeiro');
INSERT INTO public.tbaterror_legal VALUES ('teste 4');


--
-- TOC entry 5037 (class 0 OID 16412)
-- Dependencies: 221
-- Data for Name: tbfavoritos; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tbfavoritos VALUES ('a', 'teste 3: O teste verdadeiro');
INSERT INTO public.tbfavoritos VALUES ('a', 'teste 1: o começo de tudo');
INSERT INTO public.tbfavoritos VALUES ('lucas@email.com', 'teste 3: O teste verdadeiro');
INSERT INTO public.tbfavoritos VALUES ('a', 'teste 3: O teste verdadeiro');
INSERT INTO public.tbfavoritos VALUES ('a', 'teste 3: O teste verdadeiro');
INSERT INTO public.tbfavoritos VALUES ('mateusayjin@email.com', 'Matrix');
INSERT INTO public.tbfavoritos VALUES ('mateusayjin@email.com', 'O Exorcista');
INSERT INTO public.tbfavoritos VALUES ('gabriela@email.com', 'Duna');


--
-- TOC entry 5036 (class 0 OID 16398)
-- Dependencies: 220
-- Data for Name: tbfilmes; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tbfilmes VALUES ('It: A Coisa', 'Em Derry, Maine, um grupo de crianças enfrenta uma entidade sobrenatural que assume a forma dos maiores medos de cada um, conhecida como Pennywise, o palhaço dançarino.', 'Terror', 2, 15, 0, 7.3, 512880);
INSERT INTO public.tbfilmes VALUES ('O Iluminado', 'Um escritor leva a família para trabalhar como zelador de um hotel isolado durante o inverno, onde forças sobrenaturais o levam à loucura enquanto seu filho possui habilidades paranormais.', 'Terror', 2, 26, 0, 8.4, 1050000);
INSERT INTO public.tbfilmes VALUES ('Hereditário', 'Após a morte da matriarca, uma família começa a descobrir segredos sombrios sobre seu passado enquanto membros perturbadores da linhagem surgem das sombras.', 'Terror', 2, 7, 0, 7.3, 287000);
INSERT INTO public.tbfilmes VALUES ('O Exorcista', 'Uma menina de 12 anos é possuída por um demônio misterioso, e sua mãe desesperada busca a ajuda de dois padres para realizar um exorcismo.', 'Terror', 2, 2, 0, 8.1, 440000);
INSERT INTO public.tbfilmes VALUES ('Midsommar', 'Um casal em crise viaja para um festival de verão na Suécia, mas o que parece um idílico ritual rural logo revela um culto sinistro e violento.', 'Terror', 2, 20, 0, 7.1, 270000);
INSERT INTO public.tbfilmes VALUES ('A Bruxa', 'Na Nova Inglaterra do século XVII, uma família de colonos puritanos é aterrorizada por forças malignas após ser banida de sua aldeia, enquanto suspeitas de bruxaria recaem sobre a filha mais velha.', 'Terror', 1, 32, 0, 6.9, 210000);
INSERT INTO public.tbfilmes VALUES ('Interestelar', 'Um ex-piloto da NASA embarca em uma viagem através de um buraco de minhoca recém-descoberto para garantir a sobrevivência da humanidade em outro sistema solar.', 'Ficcao', 2, 49, 0, 8.7, 1900000);
INSERT INTO public.tbfilmes VALUES ('Matrix', 'Um hacker descobre que a realidade como a conhece é uma simulação criada por máquinas e se junta a uma rebelião contra seus controladores.', 'Ficcao', 2, 16, 0, 8.7, 1950000);
INSERT INTO public.tbfilmes VALUES ('Blade Runner 2049', 'Um jovem caçador de replicantes descobre um segredo enterrado há muito tempo que tem o potencial de mergulhar o que resta da sociedade no caos.', 'Ficcao', 2, 44, 0, 8, 620000);
INSERT INTO public.tbfilmes VALUES ('Duna', 'Um jovem nobre assume o controle do planeta mais importante do universo para salvar seu povo e garantir o futuro de sua família.', 'Ficcao', 2, 35, 0, 8, 750000);
INSERT INTO public.tbfilmes VALUES ('2001: Uma Odisseia no Espaço', 'Uma viagem espacial até Júpiter com a inteligência artificial HAL 9000 torna-se perturbadora após a descoberta de um monolito negro que influencia a evolução humana.', 'Ficcao', 2, 29, 0, 8.3, 720000);
INSERT INTO public.tbfilmes VALUES ('Arrival', 'Uma linguista é recrutada para se comunicar com extraterrestres que chegam à Terra e descobre que aprender sua linguagem tem consequências inesperadas na percepção do tempo.', 'Ficcao', 1, 56, 0, 7.9, 590000);
INSERT INTO public.tbfilmes VALUES ('Orgulho e Preconceito', 'A jovem Elizabeth Bennet navega questões de educação, moralidade e casamento na Inglaterra do século XIX ao se envolver com o orgulhoso Sr. Darcy.', 'Romance', 2, 9, 0, 7.8, 260000);
INSERT INTO public.tbfilmes VALUES ('Titanic', 'Um artista pobre e uma jovem aristocrata se apaixonam a bordo do fatídico transatlântico RMS Titanic durante sua viagem inaugural em 1912.', 'Romance', 3, 14, 0, 7.9, 1200000);
INSERT INTO public.tbfilmes VALUES ('Antes do Amanhecer', 'Um americano e uma francesa se conhecem em um trem e passam uma noite caminhando por Viena, conversando sobre amor, vida e o futuro.', 'Romance', 1, 41, 0, 8.1, 230000);
INSERT INTO public.tbfilmes VALUES ('La La Land', 'Uma atriz em ascensão e um músico de jazz se apaixonam em Los Angeles enquanto perseguem seus sonhos, enfrentando os sacrifícios que o sucesso exige.', 'Romance', 2, 8, 0, 8, 690000);
INSERT INTO public.tbfilmes VALUES ('Diário de uma Paixão', 'Um casal idoso relembra sua história de amor apaixonada e cheia de obstáculos, da juventude ao presente, em uma narrativa comovente sobre o poder duradouro do amor.', 'Romance', 2, 3, 0, 7.9, 470000);
INSERT INTO public.tbfilmes VALUES ('Amor Sublime Amor', 'Baseado em Shakespeare, dois jovens de gangues rivais se apaixonam nas ruas de Nova York, mas seu relacionamento é ameaçado pelos conflitos entre seus grupos.', 'Romance', 1, 33, 0, 7.6, 89000);
INSERT INTO public.tbfilmes VALUES ('O Rei do Show', 'Baseado na história de P.T. Barnum, o filme acompanha a criação do maior espetáculo do mundo, explorando sonhos, família e aceitação.', 'Musical', 1, 45, 0, 7.6, 250000);
INSERT INTO public.tbfilmes VALUES ('Moulin Rouge!', 'Em Paris em 1900, um jovem escritor se apaixona por uma cortesã que também é amada pelo proprietário do famoso cabaré Moulin Rouge.', 'Musical', 2, 7, 0, 7.6, 350000);
INSERT INTO public.tbfilmes VALUES ('Mamma Mia!', 'Uma noiva quer descobrir qual de seus três ex-namorados é seu pai antes do casamento, levando todos a uma ilha grega cheia de músicas do ABBA.', 'Musical', 1, 49, 0, 6.4, 230000);
INSERT INTO public.tbfilmes VALUES ('Grease', 'Um romance de verão entre Danny e Sandy complica quando os dois se reencontram no mesmo colégio e precisam lidar com diferenças de grupos sociais.', 'Musical', 1, 50, 0, 7.2, 310000);
INSERT INTO public.tbfilmes VALUES ('Chicago', 'Duas mulheres acusadas de assassinato competem pela atenção da mídia com a ajuda de um advogado corrupto na Chicago dos anos 1920.', 'Musical', 1, 53, 0, 7.2, 280000);
INSERT INTO public.tbfilmes VALUES ('Bohemian Rhapsody', 'O filme retrata a ascensão meteórica do Queen e do carismático vocalista Freddie Mercury, culminando na lendária apresentação no Live Aid em 1985.', 'Musical', 2, 14, 0, 7.9, 620000);


--
-- TOC entry 5038 (class 0 OID 16419)
-- Dependencies: 222
-- Data for Name: tblistas; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tblistas VALUES ('lucas@email.com', 'filmes legais');
INSERT INTO public.tblistas VALUES ('mateusayjin@email.com', 'sayjin');


--
-- TOC entry 5039 (class 0 OID 16559)
-- Dependencies: 223
-- Data for Name: tblucasdaofilmes_legais; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5041 (class 0 OID 16603)
-- Dependencies: 225
-- Data for Name: tbmateusayjindaosayjin; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tbmateusayjindaosayjin VALUES ('Hereditário');
INSERT INTO public.tbmateusayjindaosayjin VALUES ('O Exorcista');


--
-- TOC entry 5035 (class 0 OID 16388)
-- Dependencies: 219
-- Data for Name: tbusuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tbusuarios VALUES ('lucas@email.com', 'lucas', '@Sd123');
INSERT INTO public.tbusuarios VALUES ('teste@', 'teste', 'teste');
INSERT INTO public.tbusuarios VALUES ('teste2@', 'teste2', 'teste@');
INSERT INTO public.tbusuarios VALUES ('a', 'teste a', 'a');
INSERT INTO public.tbusuarios VALUES ('seila@email.com', 'seila', '123456');
INSERT INTO public.tbusuarios VALUES ('mateusayjin@email.com', 'mateus', 'sayjin');
INSERT INTO public.tbusuarios VALUES ('gabriela@email.com', 'gabriela', '123456');


--
-- TOC entry 4887 (class 2606 OID 16405)
-- Name: tbfilmes tbfilmes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbfilmes
    ADD CONSTRAINT tbfilmes_pkey PRIMARY KEY (titulo);


--
-- TOC entry 4885 (class 2606 OID 16397)
-- Name: tbusuarios tbusuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbusuarios
    ADD CONSTRAINT tbusuarios_pkey PRIMARY KEY (email);


-- Completed on 2026-05-15 21:39:36

--
-- PostgreSQL database dump complete
--

\unrestrict xHBblqkZNoI15yVOsrOK4ym4wM4NeDbAFB6Udf62HihfSUrZzffnV1YmfKPaX8g

-- Completed on 2026-05-15 21:39:36

--
-- PostgreSQL database cluster dump complete
--

