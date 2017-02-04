(ns datatable.demo
  (:require [datatable.core]
            [datatable.sql.fns :as dtc]
            [korma.db :as db]
            [korma.core :as core])
  (:use [datatable.core]))

;;"jdbc:spark://local/MyApp"

;; FIXME: how to pass in additional opts??
(def db {:classname   "spark.jdbc.Driver"
         :subprotocol "spark"
         :subname     "//local/MyApp"
         :delimiters  "`"
         :make-pool?  false})

(db/defdb spark db)

(core/select "dual")


;; (defn spark
;;   "Create a database specification for an Oracle database. Opts should include keys
;;   for :user and :password. You can also optionally set host and port."
;;   [{:keys [host port make-pool?]
;;     :or {host "localhost", port 1521, make-pool? true}
;;     :as opts}]
;;   (merge {:classname "oracle.jdbc.driver.OracleDriver" ; must be in classpath
;;           :subprotocol "oracle:thin"
;;           :subname (str "@" host ":" port)
;;           :make-pool? make-pool?}
;;          (dissoc opts :host :port)))

;; (select "dual")

;; (query
;;  (-> (as-dt "user")
;;      (select [= (+ :a :b) (lit 42)] [:a [(sum :b) :sum-b]])
;;      (select)))