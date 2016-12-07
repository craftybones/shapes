(ns shapes.utils
  (:gen-class))
  
(defn flip [f]
  (fn [& args]
    (apply f (reverse args))))
