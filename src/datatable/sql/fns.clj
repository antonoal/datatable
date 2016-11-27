(ns datatable.sql.fns
  (:require [clojure.core :as core]
            [datatable.utils :as utils])
  (:use [datatable.utils])
  (:refer-clojure :only [defn apply cons]))

(def lit utils/generated)

;; Boolean

(defn = [l r] (infix-fn "=" l r))
(defn > [l r] (infix-fn ">" l r))
(defn null? [x] (infix-fn "is null" x (lit "")))

;; Arithmetics

(defn + ([l r] (infix-fn "+" l r))
  ([l r & more] (infix-fn "+" l (apply + (cons r more)))))
;; (defn * [l r] (infix-fn l "*" r))

;; Aggregate

(defn sum [c] (postfix-fn "sum" c))