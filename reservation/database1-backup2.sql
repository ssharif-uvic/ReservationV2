--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.9
-- Dumped by pg_dump version 9.6.9

-- Started on 2018-06-20 17:25:08 -05

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE database1;
--
-- TOC entry 2212 (class 1262 OID 25571)
-- Name: database1; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE database1 WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';


ALTER DATABASE database1 OWNER TO postgres;

\connect database1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 8 (class 2615 OID 25572)
-- Name: schema1; Type: SCHEMA; Schema: -; Owner: user1
--

CREATE SCHEMA schema1;


ALTER SCHEMA schema1 OWNER TO user1;

--
-- TOC entry 1 (class 3079 OID 12429)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2215 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 190 (class 1259 OID 25852)
-- Name: destination; Type: TABLE; Schema: public; Owner: user1
--

CREATE TABLE public.destination (
    destinationid integer NOT NULL,
    airport character varying(255),
    city character varying(255),
    country character varying(255)
);


ALTER TABLE public.destination OWNER TO user1;

--
-- TOC entry 189 (class 1259 OID 25850)
-- Name: destination_destinationid_seq; Type: SEQUENCE; Schema: public; Owner: user1
--

CREATE SEQUENCE public.destination_destinationid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.destination_destinationid_seq OWNER TO user1;

--
-- TOC entry 2216 (class 0 OID 0)
-- Dependencies: 189
-- Name: destination_destinationid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user1
--

ALTER SEQUENCE public.destination_destinationid_seq OWNED BY public.destination.destinationid;


--
-- TOC entry 192 (class 1259 OID 25863)
-- Name: person; Type: TABLE; Schema: public; Owner: user1
--

CREATE TABLE public.person (
    personid integer NOT NULL,
    firstname character varying(255),
    lastname character varying(255),
    usertype integer
);


ALTER TABLE public.person OWNER TO user1;

--
-- TOC entry 191 (class 1259 OID 25861)
-- Name: person_personid_seq; Type: SEQUENCE; Schema: public; Owner: user1
--

CREATE SEQUENCE public.person_personid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.person_personid_seq OWNER TO user1;

--
-- TOC entry 2217 (class 0 OID 0)
-- Dependencies: 191
-- Name: person_personid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user1
--

ALTER SEQUENCE public.person_personid_seq OWNED BY public.person.personid;


--
-- TOC entry 194 (class 1259 OID 25874)
-- Name: reservation; Type: TABLE; Schema: public; Owner: user1
--

CREATE TABLE public.reservation (
    reservationid integer NOT NULL,
    reservationdate timestamp without time zone,
    reservationstatus character varying(255),
    traveldate timestamp without time zone,
    destinationid integer NOT NULL,
    personid integer NOT NULL
);


ALTER TABLE public.reservation OWNER TO user1;

--
-- TOC entry 193 (class 1259 OID 25872)
-- Name: reservation_reservationid_seq; Type: SEQUENCE; Schema: public; Owner: user1
--

CREATE SEQUENCE public.reservation_reservationid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reservation_reservationid_seq OWNER TO user1;

--
-- TOC entry 2218 (class 0 OID 0)
-- Dependencies: 193
-- Name: reservation_reservationid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user1
--

ALTER SEQUENCE public.reservation_reservationid_seq OWNED BY public.reservation.reservationid;


--
-- TOC entry 186 (class 1259 OID 25573)
-- Name: Destination; Type: TABLE; Schema: schema1; Owner: user1
--

CREATE TABLE schema1."Destination" (
    "DestinationId" integer NOT NULL,
    "Country" text,
    "City" text,
    "Airport" text
);


ALTER TABLE schema1."Destination" OWNER TO user1;

--
-- TOC entry 187 (class 1259 OID 25579)
-- Name: Reservation; Type: TABLE; Schema: schema1; Owner: user1
--

CREATE TABLE schema1."Reservation" (
    "ReservationId" integer NOT NULL,
    "ReservationDate" date,
    "CustomerId" integer,
    "DestinationId" integer,
    "ReservationStatus" text
);


ALTER TABLE schema1."Reservation" OWNER TO user1;

--
-- TOC entry 188 (class 1259 OID 25585)
-- Name: User; Type: TABLE; Schema: schema1; Owner: user1
--

CREATE TABLE schema1."User" (
    "UserId" integer NOT NULL,
    "FirstName" text,
    "LastName" text,
    "UserType" text
);


ALTER TABLE schema1."User" OWNER TO user1;

--
-- TOC entry 2071 (class 2604 OID 25855)
-- Name: destination destinationid; Type: DEFAULT; Schema: public; Owner: user1
--

ALTER TABLE ONLY public.destination ALTER COLUMN destinationid SET DEFAULT nextval('public.destination_destinationid_seq'::regclass);


--
-- TOC entry 2072 (class 2604 OID 25866)
-- Name: person personid; Type: DEFAULT; Schema: public; Owner: user1
--

ALTER TABLE ONLY public.person ALTER COLUMN personid SET DEFAULT nextval('public.person_personid_seq'::regclass);


--
-- TOC entry 2073 (class 2604 OID 25877)
-- Name: reservation reservationid; Type: DEFAULT; Schema: public; Owner: user1
--

ALTER TABLE ONLY public.reservation ALTER COLUMN reservationid SET DEFAULT nextval('public.reservation_reservationid_seq'::regclass);


--
-- TOC entry 2081 (class 2606 OID 25860)
-- Name: destination destination_pkey; Type: CONSTRAINT; Schema: public; Owner: user1
--

ALTER TABLE ONLY public.destination
    ADD CONSTRAINT destination_pkey PRIMARY KEY (destinationid);


--
-- TOC entry 2083 (class 2606 OID 25871)
-- Name: person person_pkey; Type: CONSTRAINT; Schema: public; Owner: user1
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (personid);


--
-- TOC entry 2085 (class 2606 OID 25879)
-- Name: reservation reservation_pkey; Type: CONSTRAINT; Schema: public; Owner: user1
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (reservationid);


--
-- TOC entry 2075 (class 2606 OID 25592)
-- Name: Destination Destination_pkey; Type: CONSTRAINT; Schema: schema1; Owner: user1
--

ALTER TABLE ONLY schema1."Destination"
    ADD CONSTRAINT "Destination_pkey" PRIMARY KEY ("DestinationId");


--
-- TOC entry 2079 (class 2606 OID 25594)
-- Name: User Person_pkey; Type: CONSTRAINT; Schema: schema1; Owner: user1
--

ALTER TABLE ONLY schema1."User"
    ADD CONSTRAINT "Person_pkey" PRIMARY KEY ("UserId");


--
-- TOC entry 2077 (class 2606 OID 25596)
-- Name: Reservation Reservation_pkey; Type: CONSTRAINT; Schema: schema1; Owner: user1
--

ALTER TABLE ONLY schema1."Reservation"
    ADD CONSTRAINT "Reservation_pkey" PRIMARY KEY ("ReservationId");


--
-- TOC entry 2089 (class 2606 OID 25885)
-- Name: reservation fk_b8h9teib1a59pcpsku9ihqywa; Type: FK CONSTRAINT; Schema: public; Owner: user1
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT fk_b8h9teib1a59pcpsku9ihqywa FOREIGN KEY (personid) REFERENCES public.person(personid);


--
-- TOC entry 2088 (class 2606 OID 25880)
-- Name: reservation fk_tnuwprcv18i5l3w3b79cwwdb0; Type: FK CONSTRAINT; Schema: public; Owner: user1
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT fk_tnuwprcv18i5l3w3b79cwwdb0 FOREIGN KEY (destinationid) REFERENCES public.destination(destinationid);


--
-- TOC entry 2086 (class 2606 OID 25597)
-- Name: Reservation FK_Destination_Reservation; Type: FK CONSTRAINT; Schema: schema1; Owner: user1
--

ALTER TABLE ONLY schema1."Reservation"
    ADD CONSTRAINT "FK_Destination_Reservation" FOREIGN KEY ("DestinationId") REFERENCES schema1."Destination"("DestinationId");


--
-- TOC entry 2087 (class 2606 OID 25602)
-- Name: Reservation FK_User_Reservation; Type: FK CONSTRAINT; Schema: schema1; Owner: user1
--

ALTER TABLE ONLY schema1."Reservation"
    ADD CONSTRAINT "FK_User_Reservation" FOREIGN KEY ("CustomerId") REFERENCES schema1."User"("UserId");


--
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-06-20 17:25:08 -05

--
-- PostgreSQL database dump complete
--

