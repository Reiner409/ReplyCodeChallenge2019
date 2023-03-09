package it.ringmaster.fantastici4.rc18.cloud;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Provider {

    private String name;

    List<Region> regions;
}
