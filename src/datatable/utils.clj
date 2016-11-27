(ns datatable.utils
  (:require [korma.sql.engine :as eng]
            [korma.sql.utils :as utils]))

(defn generated [x] (utils/generated x))
(defn infix-fn [op k v] (eng/infix k op v))
(defn postfix-fn [op & vs] (apply eng/sql-func (cons op vs)))
