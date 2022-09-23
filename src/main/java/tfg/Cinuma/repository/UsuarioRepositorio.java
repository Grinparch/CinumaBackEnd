package tfg.Cinuma.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tfg.Cinuma.Modelo.Usuario;

/**
 *
 * @author jsnie
 */
public interface UsuarioRepositorio extends MongoRepository<Usuario, String>{
    
    Usuario findByUsername(String username);
    
    Usuario findByUserId(String userId);
    
    Usuario findByPerfil(String perfil);
    
    void deleteUsuarioByUsername(String username);
}
