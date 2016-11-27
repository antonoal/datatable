(ns datatable.core
  (:require  [korma.core :as kc]
             [clojure.walk :as walk]))

;; FIXME: this should be available for the user to extended, ie dynamic maybe? Need to think the whole concept through
;; Also it could resolve to current namespace alias rather than the full ns
(defn- dfc-syms []
  (->> (ns-publics 'datatable.sql.fns)
       (keys)
       (map #(vector % (symbol "datatable.sql.fns" (name %))))
       (into {})
       ))

(defmacro select [dt & args] `(~dt ~@args))
;; (defn select [dt & args] (apply dt args))

(defmacro query [form]
  (let [dfc-syms (dfc-syms)]
    (walk/postwalk-replace dfc-syms form)))

;;FIXME: check map destructuring and do renaming
;;(defn as-korma-rename [])
(defn as-dt [entity]
  (fn ([] (kc/as-sql (kc/select* entity)))
    ([[& j]] ((as-dt entity) [] j [] []))
    ([[& i] [& j]] ((as-dt entity) i j [] []))
    ([[& i] [& j] [& by] [& sort]]
     (-> (kc/select* entity)
         (kc/where* (eval (apply list i)))
         ;; FIXME: add group-by and order-by clauses
         (#(apply kc/fields (cons % j)))
         (as-dt)
         ))
    ))
