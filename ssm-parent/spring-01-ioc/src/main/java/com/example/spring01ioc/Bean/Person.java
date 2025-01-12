package com.example.spring01ioc.Bean;

import lombok.Data;

@Data
public class Person {
    private String name;
    private int age;
    private String gender;
}
/*
@Data is a Lombok annotation that generates all the boilerplate code typically associated with simple “data-holding” classes.
In particular, it does the following automatically:
	•	@Getter and @Setter for all fields (generates getters and setters)
	•	@ToString (a toString method including all fields)
	•	@EqualsAndHashCode (equals and hashCode methods based on the fields)
	•	@RequiredArgsConstructor for final fields (generates a constructor if any fields are final or marked with @NonNull)

    Essentially, @Data bundles together these Lombok annotations.
    so you don’t have to write them individually, reducing boilerplate.
 */