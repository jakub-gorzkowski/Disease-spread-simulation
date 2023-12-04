public class Main {
    public static void main(String[] args) {
        /*
        TODO:
            (wymagania symulacji)
            - symulacja na dwuwymiarowym obszarze n x m (wymiary w metrach, więc double) // done
            - wektory osobników przemieszczają się w dowolnym kierunku z losową szybkością (max 2.5 m/s) // done
            - docierając do granicy obszaru osobnik może zawrócić (50% prawdopodobieństwa), opuścić obszar (50% prawdopodobieństwa) // done
            - w trakcie symulacji nowi osobnicy wkraczają do obszaru w losowych obszarach tak aby zachować ciągłość populacji // done
            - każdy wkraczający na obszar osobnik ma 10% prawdopodobieństwo zakażenia się wirusem // done
            - każdy osobnik jest: // done
                odporny lub wrażliwy na zakażenie
                    jeżeli jest wrażliwy na zakażenie to jest:
                        zdrowy lub zakażony
                            jeżeli jest zakażony to:
                                posiada objawy lub nieposiada objawów
            - osobnik zdrowy ale nieodporny zaraża się od zakażonego osobnika gdy: // done
                odległość między nimi wynosi <= 2 metry oraz czas gdy ta odległość jest trzymana >= 3 sekundy
            - prawdopodobieństwo zakażenia od osobnika bezobjawowego wynosi 50% // done
            - prawdopodobieństwo zakażenia od osobnika objawowego wynosi 100% // done
            - zakażony osobnik przetrzymuje zakażenie od 20 do 30 sekund po czym zdrowieje i staje się osobnikiem odpornym // done

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

        /*

        // dodać usuwanie obiektów które wyszły po za obszar symulacji i wstawiać w ich miejsce nowe wkraczające
*/

        // klasy do usunięcia: Board, GUI, UserInterface
        new Window(800, 600);
    }
}