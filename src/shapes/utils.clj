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

(defn -tab
  "A private method that does the bulk of the work for there-and-back.
  returns a closure that lazily recurses. -tab requires:
  above? below? from

  above? is a function that checks whether a number is above another.
  Based on step, this could either be > or <

  below? is similar to above? and should ideally be the opposite

  from is where the range starts"
  [[above? below? from]]
  (fn -repeat [f t s]
    (if (below? f from)
      '()
      (let [nf (+ f s)
            ns (if (above? nf t) (- s) s)]
        (lazy-seq (cons f (-repeat (+ f ns) t ns)))))))

(defn there-and-back
  "creates a range that ranges from start to end and back to start"
  ([to] (there-and-back 0 to 1))
  ([from to] (there-and-back from to 1))
  ([from to step]
   (let [[above? below?] (if (pos? step) [> <] [< >])
         closure-args [above? below? from]]
     (if (above? from to)
       '()
       ((-tab closure-args) from to step)))))
