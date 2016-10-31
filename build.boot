(set-env!
  :source-paths #{"src"}
  :dependencies '[[org.clojure/clojure "1.8.0"]
                  [nightlight "1.1.0" :scope "test"]])

(require '[nightlight.boot :refer [nightlight]])

(deftask build []
  (comp
    (aot :namespace '#{clojure-basics.core})
    (pom :project 'clojure-basics
         :version "1.0.0")
    (uber)
    (jar :main 'clojure-basics.core)
    (target)))

(deftask run []
  (comp
    (wait)
    (nightlight :port 4000)))

