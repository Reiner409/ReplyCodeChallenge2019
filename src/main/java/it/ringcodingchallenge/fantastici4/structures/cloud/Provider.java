package it.ringcodingchallenge.fantastici4.structures.cloud;

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
