package RestClient;

import Entities.Pojo;

public interface RestClient {
	public Pojo[] selectAll();

	public Pojo selectOne(int id);

	public boolean Update(int id, Pojo pojo);

	public boolean Save(Pojo pojo);

	public boolean Delete(int id);
}
