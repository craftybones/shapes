(ns shapes.utils
  (:gen-class))
  
(defn flip [f]
  (fn [& args]
    (apply f (reverse args))))

(def stringify (partial apply str))

(def repeat-string (comp stringify repeat))
