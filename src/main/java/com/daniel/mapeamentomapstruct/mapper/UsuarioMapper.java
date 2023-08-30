package com.daniel.mapeamentomapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.daniel.mapeamentomapstruct.model.Usuario;
import com.daniel.mapeamentomapstruct.requests.UsuarioDTO;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    // Indica que o atributo 'nome' da entidade será mapeado para o atributo 'name' do DTO
    @Mapping(source = "nome", target = "name")
    UsuarioDTO toDTO(Usuario usuario);

    // Indica que o atributo 'name' do DTO será mapeado para o atributo 'nome' da entidade
    @Mapping(source = "name", target = "nome")
    Usuario toEntity(UsuarioDTO usuarioDTO);
}

/* Observação: 
 * 
 * A anotação @Mapping é usada no MapStruct para especificar explicitamente como os atributos de uma classe devem ser mapeados para os atributos 
 * de outra classe. A anotação permite que você indique as correspondências personalizadas entre os atributos, especialmente quando os nomes dos 
 * atributos não correspondem diretamente entre as duas classes.
 * 
 * Aqui está o que os parâmetros da anotação @Mapping fazem:
 * 
 *  -> source: Este é o nome do atributo na classe de origem (por exemplo, a entidade Usuario) que você deseja mapear. No exemplo, estamos 
 *     mapeando o atributo nome da entidade Usuario.
 * 
 *  -> target: Este é o nome do atributo na classe de destino (por exemplo, o DTO UserDTO) onde você deseja que o valor seja mapeado. No exemplo, 
 *     estamos mapeando para o atributo name do DTO UserDTO.
 * 
 * Isso é útil quando os nomes dos atributos não correspondem diretamente entre as classes que você está mapeando. Por exemplo, na classe 
 * Usuario temos nome, e na classe UserDTO temos name. O MapStruct, por padrão, procurará atributos com nomes correspondentes, mas quando os 
 * nomes não correspondem, você pode usar @Mapping para indicar explicitamente a correspondência correta.
 * 
 * Com essa configuração, o MapStruct sabe como realizar as correspondências corretas entre os atributos com nomes diferentes. Isso lhe dá um 
 * controle granular sobre os mapeamentos, mesmo quando os nomes não são idênticos.
 * 
*/
