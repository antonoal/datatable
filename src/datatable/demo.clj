(ns datatable.demo
  (:require [datatable.core]
            [datatable.sql.fns :as dtc])
  (:use [datatable.core]))

(query
 (-> (as-dt "user")
     (select [= (+ :a :b) (lit 42)] [:a [(sum :b) :sum-b]])
     (select)))