package com.eafit.retoamadeus.repositories;

import com.eafit.retoamadeus.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * UserRepository es la interfaz que extiende de JpaRepository para la entidad UserEntity.
 * 
 * <p>Esta interfaz se encarga de proporcionar las operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * para la entidad UserEntity, que representa la tabla de usuarios en la base de datos.
 * Al extender JpaRepository, ya contamos con métodos predefinidos como:
 * <ul>
 *   <li><b>save(UserEntity userEntity)</b>: Guarda o actualiza un usuario.</li>
 *   <li><b>findById(Long id)</b>: Busca un usuario por su ID.</li>
 *   <li><b>deleteById(Long id)</b>: Elimina un usuario por su ID.</li>
 *   <li><b>findAll()</b>: Retorna todos los usuarios.</li>
 * </ul>
 * Además, se definen métodos personalizados para realizar búsquedas específicas basadas en
 * las convenciones de nomenclatura de Spring Data JPA.</p>
 * 
 * <p><b>Conceptos clave:</b></p>
 * <ul>
 *   <li>
 *     <b>UserEntity:</b> Es la clase que define la estructura de un usuario en la base de datos.
 *     Cada objeto UserEntity se corresponde con una fila en la tabla (por ejemplo, con atributos como id, name o nombre, email, etc.).
 *   </li>
 *   <li>
 *     <b>UserRepository:</b> Es el componente encargado de interactuar con la base de datos para
 *     realizar operaciones sobre UserEntity, usando métodos automáticos generados por Spring Data JPA.
 *   </li>
 * </ul>
 * 
 * <p><b>Ejemplos de métodos personalizados:</b></p>
 * <ul>
 *   <li>
 *     <b>Optional&lt;UserEntity&gt; findByName(String name);</b><br>
 *     - "findBy": indica que se trata de una búsqueda.<br>
 *     - "Name": hace referencia al atributo <b>name</b> de la entidad UserEntity.<br>
 *     Spring Data JPA genera internamente una consulta similar a:
 *     <pre>SELECT u FROM UserEntity u WHERE u.name = ?1</pre>
 *   </li>
 *   <li>
 *     Si deseas buscar por "nombre" en español, primero asegúrate de que tu entidad tenga el atributo
 *     <b>nombre</b> (por ejemplo, <code>private String nombre;</code>) y define el método:
 *     <pre>Optional&lt;UserEntity&gt; findByNombre(String nombre);</pre>
 *     Esto generará una consulta similar a:
 *     <pre>SELECT u FROM UserEntity u WHERE u.nombre = ?1</pre>
 *   </li>
 *   <li>
 *     <b>Optional&lt;UserEntity&gt; findByEmail(String email);</b> Busca un usuario por su correo electrónico.
 *   </li>
 *   <li>
 *     <b>Optional&lt;UserEntity&gt; findByNameAndEmail(String name, String email);</b> Busca un usuario
 *     que coincida tanto en nombre como en correo electrónico.
 *   </li>
 *   <li>
 *     <b>boolean existsByEmail(String email);</b> Verifica si existe un usuario con el correo proporcionado.
 *   </li>
 * </ul>
 * 
 * <p>Esta documentación sirve como referencia para comprender cómo se estructuran y utilizan los
 * métodos en este repositorio, apoyándose en las convenciones de Spring Data JPA para evitar escribir
 * consultas SQL manualmente y mantener el código limpio y organizado.</p>
 * 
 * @autor Francisco Echavarría
 * @version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


    UserEntity save(UserEntity userEntity);

    Optional<UserEntity> findByName(String name); // Encuentra un usuario por su nombre

    Optional<UserEntity> findByEmail(String email); // Encuentra un usuario por su correo electrónico

    Optional<UserEntity> findByNameAndEmail(String name, String email); // Encuentra un usuario por su nombre y correo electrónico

    boolean existsByEmail(String email); // Verifica si existe un usuario con un correo electrónico específic Se debe revisar este código
    // Buscar una persona por cédula
}