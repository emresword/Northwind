package coding.northwind.business.abstracts;

import coding.northwind.core.entities.User;
import coding.northwind.core.utilities.results.DataResult;
import coding.northwind.core.utilities.results.Result;

public interface UserService {
	Result add(User user);
	DataResult<User> findByEmail(String email);

}
