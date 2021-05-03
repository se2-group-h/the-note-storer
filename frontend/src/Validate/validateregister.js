export default function validateregister(values) {
    let errors = {};
  
    if (!values.firstName.trim()) {
      errors.username = 'First name required';
    }
    // else if (!/^[A-Za-z]+/.test(values.name.trim())) {
    //   errors.name = 'Enter a valid name';
    // }
    if (!values.lastName.trim()) {
        errors.lastName = 'Last name required';
      }
    if (!values.login.trim()) {
        errors.lastName = 'User-name required';
    }

    if (!values.email) {
      errors.email = 'Email required';
    } else if (!/\S+@\S+\.\S+/.test(values.email)) {
      errors.email = 'Email address is invalid';
    }
    if (!values.password) {
      errors.password = 'Password is required';
    } else if (values.password.length < 8) {
      errors.password = 'Password needs to be 8 characters or more';
    }
  
    return errors;
  }