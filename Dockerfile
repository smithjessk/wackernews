FROM clojure
COPY . /usr/src/wackernews
WORKDIR /usr/src/wackernews
CMD ["lein", "run"]
