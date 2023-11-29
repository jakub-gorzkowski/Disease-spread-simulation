public class Main {
    public static void main(String[] args) {
        /*
        TODO:
            (wymagania symulacji)
            - symulacja na dwuwymiarowym obszarze n x m (wymiary w metrach, więc double)
            - wektory osobników przemieszczają się w dowolnym kierunku z losową szybkością (max 2.5 m/s)
            - docierając do granicy obszaru osobnik może zawrócić (50% prawdopodobieństwa), opuścić obszar (50% prawdopodobieństwa)
            - w trakcie symulacji nowi osobnicy wkraczają do obszaru w losowych obszarach tak aby zachować ciągłość populacji
            - każdy wkraczający na obszar osobnik ma 10% prawdopodobieństwo zakażenia się wirusem
            - każdy osobnik jest:
                odporny lub wrażliwy na zakażenie
                    jeżeli jest wrażliwy na zakażenie to jest:
                        zdrowy lub zakażony
                            jeżeli jest zakażony to:
                                posiada objawy lub nieposiada objawów
            - osobnik zdrowy ale nieodporny zaraża się od zakażonego osobnika gdy:
                odległość między nimi wynosi <= 2 metry oraz czas gdy ta odległość jest trzymana >= 3 sekundy
            - prawdopodobieństwo zakażenia od osobnika bezobjawowego wynosi 50%
            - prawdopodobieństwo zakażenia od osobnika objawowego wynosi 100%
            - zakażony osobnik przetrzymuje zakażenie od 20 do 30 sekund po czym zdrowieje i staje się osobnikiem odpornym

            (wymagania programu)
            - możliwe jest dokonanie zapisu oraz odczyt jego stanu w dowolnym momencie od rozpoczęcia
            - sekunda symulacji to 25 kroków
         */

        /**
         * Własne spostrzeżenia:
         *  - Memento zapisujemy co każdą sekundę symulacji w liście lub stosie
         *  - Memento ma iść na stan planszy
         *  - Stan ma iść na osobników
         */

    }
}