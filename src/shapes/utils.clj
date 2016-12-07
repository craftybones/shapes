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

(defn there-and-back
  "creates a range that ranges from start to end and back to start"
  ([to] (there-and-back 0 to 1))
  ([from to] (there-and-back from to 1))
  ([from to step]
   (let [[above? below?] (if (pos? step) [> <] [< >])]
     ((fn tab [f t s]
        (if (below? f from)
          '()
          (let [nf (+ f s)
                ns (if (above? nf t) (- s) s)]
            (lazy-seq (cons f (tab (+ f ns) t ns)))))) from to step))))
