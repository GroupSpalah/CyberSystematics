package ls_11_23.ls_16_11_23.medicines;

import java.util.List;
import java.util.stream.Stream;

public class TestPharmacy {
    public static void main(String[] args) {
        List<Pharmacy> pharmacies = List.of(
                new Pharmacy("3i",         List.of("Nazonex", "Vitamin C", "Zn Supplements")),
                new Pharmacy("DS",         List.of("Vitamin C", "Advil", "DoppelHerz")),
                new Pharmacy("Kopiiochka", List.of("Ibuprofen", "Vitamin C")));

        List<String> medicinesOnline = List.of("Askorbinka", "Nazonex", "Dekatylen", "Strepsils", "Zelenka");


        List<List<Stream>> lists = List.of();

//        Pharmacy -> List<String>; Stream<String>

   /*     Stream<List<String>> listStream = pharmacies
                .stream()
                .map(pharmacy -> pharmacy.medicines());*/

             Stream<String> medicines1 = pharmacies
                .stream()
                .flatMap(pharmacy -> pharmacy.medicines().stream());

             Stream<String> medicines2 = medicinesOnline.stream();

            Stream
                    .concat(medicines1, medicines2)
                    .distinct()//Stream unique String
                    .sorted()//Stream sorted String
                    .forEach(System.out::println);

    }
}
