CREATE TABLE anime (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL UNIQUE,
    description TEXT,
    release_date DATE,
    rating DOUBLE PRECISION,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE genre (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE streaming (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE anime_genre (
    anime_id BIGINT NOT NULL,
    genre_id BIGINT NOT NULL,
    PRIMARY KEY (anime_id, genre_id),
    CONSTRAINT fk_anime FOREIGN KEY (anime_id) REFERENCES anime(id) ON DELETE CASCADE,
    CONSTRAINT fk_genre FOREIGN KEY (genre_id) REFERENCES genre(id) ON DELETE CASCADE
);

CREATE TABLE anime_streaming (
    anime_id BIGINT NOT NULL,
    streaming_id BIGINT NOT NULL,
    PRIMARY KEY (anime_id, streaming_id),
    CONSTRAINT fk_anime_streaming FOREIGN KEY (anime_id) REFERENCES anime(id) ON DELETE CASCADE,
    CONSTRAINT fk_streaming FOREIGN KEY (streaming_id) REFERENCES streaming(id) ON DELETE CASCADE
);

