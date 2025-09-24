--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5
-- Dumped by pg_dump version 17.5

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
-- Name: chambre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.chambre (
    id integer NOT NULL,
    numero integer NOT NULL,
    prix integer NOT NULL,
    nb_personne integer NOT NULL,
    disponible boolean DEFAULT true,
    id_client_reservation integer
);


ALTER TABLE public.chambre OWNER TO postgres;

--
-- Name: chambre_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.chambre_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.chambre_id_seq OWNER TO postgres;

--
-- Name: chambre_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.chambre_id_seq OWNED BY public.chambre.id;


--
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    id integer NOT NULL,
    nom character varying(255) NOT NULL,
    prenom character varying(255) NOT NULL,
    mail character varying(255) NOT NULL,
    motdepasse character varying(255) NOT NULL,
    point_fidelite integer NOT NULL,
    salt character varying(255)
);


ALTER TABLE public.client OWNER TO postgres;

--
-- Name: client_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.client_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.client_id_seq OWNER TO postgres;

--
-- Name: client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.client_id_seq OWNED BY public.client.id;


--
-- Name: employer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employer (
    id integer NOT NULL,
    nom character varying(255) NOT NULL,
    prenom character varying(255) NOT NULL,
    role character varying(255) NOT NULL,
    mail character varying(255) NOT NULL,
    motdepasse character varying(255) NOT NULL,
    salt character varying(255)
);


ALTER TABLE public.employer OWNER TO postgres;

--
-- Name: employer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.employer_id_seq OWNER TO postgres;

--
-- Name: employer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.employer_id_seq OWNED BY public.employer.id;


--
-- Name: evaluation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.evaluation (
    id integer NOT NULL,
    id_client integer NOT NULL,
    note integer NOT NULL,
    commentaire text,
    date date NOT NULL,
    heure time without time zone NOT NULL
);


ALTER TABLE public.evaluation OWNER TO postgres;

--
-- Name: evaluation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.evaluation_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.evaluation_id_seq OWNER TO postgres;

--
-- Name: evaluation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.evaluation_id_seq OWNED BY public.evaluation.id;


--
-- Name: evenement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.evenement (
    id integer NOT NULL,
    nom character varying(255) NOT NULL,
    date date NOT NULL,
    heure time without time zone NOT NULL,
    prix integer NOT NULL,
    place_dispo integer NOT NULL,
    nb_reserver integer NOT NULL
);


ALTER TABLE public.evenement OWNER TO postgres;

--
-- Name: evenement_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.evenement_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.evenement_id_seq OWNER TO postgres;

--
-- Name: evenement_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.evenement_id_seq OWNED BY public.evenement.id;


--
-- Name: notification; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.notification (
    id integer NOT NULL,
    id_client integer,
    id_evenement integer,
    id_employer integer,
    titre character varying(255) NOT NULL,
    description text,
    date date,
    heure time without time zone
);


ALTER TABLE public.notification OWNER TO postgres;

--
-- Name: notification_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.notification_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.notification_id_seq OWNER TO postgres;

--
-- Name: notification_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.notification_id_seq OWNED BY public.notification.id;


--
-- Name: chambre id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chambre ALTER COLUMN id SET DEFAULT nextval('public.chambre_id_seq'::regclass);


--
-- Name: client id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client ALTER COLUMN id SET DEFAULT nextval('public.client_id_seq'::regclass);


--
-- Name: employer id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer ALTER COLUMN id SET DEFAULT nextval('public.employer_id_seq'::regclass);


--
-- Name: evaluation id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evaluation ALTER COLUMN id SET DEFAULT nextval('public.evaluation_id_seq'::regclass);


--
-- Name: evenement id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement ALTER COLUMN id SET DEFAULT nextval('public.evenement_id_seq'::regclass);


--
-- Name: notification id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification ALTER COLUMN id SET DEFAULT nextval('public.notification_id_seq'::regclass);


--
-- Data for Name: chambre; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.chambre (id, numero, prix, nb_personne, disponible, id_client_reservation) FROM stdin;
1	100	55	1	t	\N
2	110	60	1	t	\N
3	120	60	2	t	\N
4	200	80	4	t	\N
\.


--
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.client (id, nom, prenom, mail, motdepasse, point_fidelite, salt) FROM stdin;
1	Lennon	Bob	pyrobarbare@gmail.com	12345	0	ITSSALT555
2	Emilio	Emile	emilEmilio@gmail.com	12345	0	ITSSALT555
3	Carel	Rebeka	Rebekarel@hotmail.fr	12345	0	ITSSALT555
\.


--
-- Data for Name: employer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employer (id, nom, prenom, role, mail, motdepasse, salt) FROM stdin;
1	Dupon	Dupont	admin	Dupon.dupont@hotmail.fr	azerty	ITSverySALT555
2	Jean	Montcuq	employer	montcuq.bestville@gmail.com	qwerty	ITSverySALT555
\.


--
-- Data for Name: evaluation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.evaluation (id, id_client, note, commentaire, date, heure) FROM stdin;
\.


--
-- Data for Name: evenement; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.evenement (id, nom, date, heure, prix, place_dispo, nb_reserver) FROM stdin;
1	Concert	2025-12-24	18:00:00	15	50	0
2	atelier poterie	2025-12-20	13:30:00	0	20	0
\.


--
-- Data for Name: notification; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.notification (id, id_client, id_evenement, id_employer, titre, description, date, heure) FROM stdin;
\.


--
-- Name: chambre_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.chambre_id_seq', 4, true);


--
-- Name: client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.client_id_seq', 3, true);


--
-- Name: employer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employer_id_seq', 2, true);


--
-- Name: evaluation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.evaluation_id_seq', 1, false);


--
-- Name: evenement_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.evenement_id_seq', 2, true);


--
-- Name: notification_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.notification_id_seq', 1, false);


--
-- Name: chambre chambre_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chambre
    ADD CONSTRAINT chambre_pkey PRIMARY KEY (id);


--
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- Name: employer employer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer
    ADD CONSTRAINT employer_pkey PRIMARY KEY (id);


--
-- Name: evaluation evaluation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evaluation
    ADD CONSTRAINT evaluation_pkey PRIMARY KEY (id);


--
-- Name: evenement evenement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement
    ADD CONSTRAINT evenement_pkey PRIMARY KEY (id);


--
-- Name: notification notification_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification
    ADD CONSTRAINT notification_pkey PRIMARY KEY (id);


--
-- Name: chambre fk_chambre_client; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chambre
    ADD CONSTRAINT fk_chambre_client FOREIGN KEY (id_client_reservation) REFERENCES public.client(id);


--
-- Name: evaluation fk_evaluation_client; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evaluation
    ADD CONSTRAINT fk_evaluation_client FOREIGN KEY (id_client) REFERENCES public.client(id);


--
-- Name: notification fk_notification_client; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification
    ADD CONSTRAINT fk_notification_client FOREIGN KEY (id_client) REFERENCES public.client(id);


--
-- Name: notification fk_notification_employer; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification
    ADD CONSTRAINT fk_notification_employer FOREIGN KEY (id_employer) REFERENCES public.employer(id);


--
-- Name: notification fk_notification_evenement; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification
    ADD CONSTRAINT fk_notification_evenement FOREIGN KEY (id_evenement) REFERENCES public.evenement(id);


--
-- Ajout de la colonne 'role' pour la gestion des rôles clients
ALTER TABLE client ADD COLUMN IF NOT EXISTS role VARCHAR(255) DEFAULT 'CLIENT';


--
-- PostgreSQL database dump complete
--

