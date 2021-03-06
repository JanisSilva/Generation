package br.com.generation.lojaGames.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.generation.lojaGames.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByUsuario (String usuario);
}