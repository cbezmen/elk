/**
 * 
 */
package app.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author cbezmen
 *
 */
@Data
@AllArgsConstructor
public class User {

	private String name;

	private String lastName;

	private Integer age;
}
