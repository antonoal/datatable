(defproject datatable "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [default/spark-jdbc_2.11 "0.0.1-SNAPSHOT"]
                 [korma "0.4.3"]]
  :jvm-opts ["-Xmx1024m" "-XX:MaxPermSize=256m"]
  :java-cmd "/usr/bin/java"
  )
