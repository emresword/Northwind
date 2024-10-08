package coding.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.northwind.business.abstracts.UserService;
import coding.northwind.core.dataAccess.UserDao;
import coding.northwind.core.entities.User;
import coding.northwind.core.utilities.results.DataResult;
import coding.northwind.core.utilities.results.Result;
import coding.northwind.core.utilities.results.SuccessDataResult;
import coding.northwind.core.utilities.results.SuccessResult;
@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add( User user) {
		this.userDao.save(user);
		return new SuccessResult("user is added");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"data is listed");
	}


}
