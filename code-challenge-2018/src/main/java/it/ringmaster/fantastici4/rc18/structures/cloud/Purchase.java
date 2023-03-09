package it.ringmaster.fantastici4.rc18.structures.cloud;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

    private int provider;
    private int region;
    private int numPackages;

}
