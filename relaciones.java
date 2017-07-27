@Entity
public class EstadoTarea
{
	@Id
	@GeneratedValue
	private Long id;

	private String estado;
}

@Entity
public class Tarea
{
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private EstadoTarea estadoTarea;
}

@Entity
public class Usuario
{
	@Id
	@GeneratedValue
	private Long id;
}

@Entity
public class Proyecto
{
	@Id
	@GeneratedValue
	private Long id;	

	@OneToMany
	private List<Tarea> tareas = new ArrayList<Tarea>;

	@ManyToMany
	private List<Usuario> usuarios = new ArrayList<Usuario>;
}