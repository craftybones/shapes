(ns shapes.core-test
  (:require [clojure.test :refer :all]
            [shapes.core :refer :all]))

(deftest filled-rectangle-m-x-n
  (let [star-filled-rectangle (partial filled-rectangle "*")]
    (testing "A simple mxn star filled rectangle"
      (is (= [] (star-filled-rectangle 0 0)))
      (is (= [""] (star-filled-rectangle 1 0)))
      (is (= ["*"] (star-filled-rectangle 1 1)))
      (is (= ["**","**"] (star-filled-rectangle 2 2)))
      (is (= ["***","***"] (star-filled-rectangle 2 3))))))

;; (deftest hollow-rectangle-m-x-n)
