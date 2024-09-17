package de.cloudypanda.stream;

import de.cloudypanda.stream.models.PersonDTO;

import java.util.List;

public class PersonStreamService extends AbstractStreamService<List<PersonDTO>> {

    public PersonStreamService(List<PersonDTO> elements) {
        super(elements);
    }

    /**
     * Filter the complex element for all elements with a name starting with "A"
     * @return a List of elements with the name starting with "A"
     */
    public List<PersonDTO> filterByNameStarting() {
        //TODO
        return null;
    }

    /**
     * Filter the complex element for all elements that are born before 2001
     * @return a list of complex elements that are born before 2001
     */
    public List<PersonDTO> filterByDateOfBirth() {
        //TODO
        return null;
    }

    /**
     * Returns a list of all the names in uppercase format
     * @return a string list of uppercase names
     */
    public List<String> mapNameToUppercase() {
        //TODO
        return null;
    }

    /**
     * Returns a list of strings with the name and age in the following format
     * <br>
     * "[name] - [dateOfBirth]"
     * @return a list of formatted strings
     */
    public List<String> mapComplexToSingleString() {
        //TODO
        return null;
    }
}
