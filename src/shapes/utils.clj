(ns shapes.utils
  (:gen-class))
  
(defn flip
  "flips order of arguments before applying f on them"
  [f]
  (fn [& args]
    (apply f (reverse args))))

(def stringify
  "strings up a sequence of elements"
  (partial apply str))

(def repeat-string
  "Strings up elements that can be repeated n times"
  (comp stringify repeat))

(defn flatten*
  "treats all arguments to it as one large list and flattens"
  [& args]
  (flatten args))
