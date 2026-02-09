(ns prc-functional-design.fib)
(declare fib)

(defn fib-w [n]
  (cond
    (< n 1)  nil
    (<= n 2) 1
    :else (+ (fib (dec n)) (fib (- n 2)))))

(declare fib (memoize fib-w))

(defn lazy-fibs []
  (map fib (rest (range))))

;; 遅延イテレータから実リストへの変換
(def real-list-of-fibs (doall (take 50 (lazy-fibs))))
