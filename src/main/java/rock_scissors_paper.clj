(ns rock-scissors-paper)

(defn battle []
  (println "Choose your weapon: r = rock, s = scissors, p = paper")
  (let [weapon (read-line)]
    (if (get {"r" true "s" true "p" true} weapon) weapon)))

(defn review [weapon_1 weapon_2]
  (let [combo [weapon_1 weapon_2]]
    (cond
      (= weapon_1 weapon_2) 0
      (= combo ["p" "r"]) 1
      (= combo ["s" "p"]) 1
      (= combo ["r" "s"]) 1
      (= combo ["r" "p"]) 2
      (= combo ["s" "r"]) 2
      (= combo ["p" "s"]) 2)
    ))

(defn result [x]
  (cond
    (= x 0) (println "Undecided")
    (= x 1) (println "You loose")
    (= x 2) (println "You won"))
    (println "valid result" (contains? #{1 2} x))
  )

(defn evaluate [round]
  (let [enemy (rand-nth ["r" "s" "p"])
        you (battle)
        review (review enemy you)]
    (println "round" round)
    (println "You choose" you)
    (println "Your enemy choose" enemy)
    (result review )
    ))

(loop [x 1]
  (when (< x 4)
    (evaluate x)
    (recur(+ x 1))))
