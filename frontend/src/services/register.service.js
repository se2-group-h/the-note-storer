const registerUrl = 'http://trn-staging-back.us-east-2.elasticbeanstalk.com/api/signup';

const registerAsync = async (registerData) => {
    const data = {
        login: registerData.login,
        password: registerData.password,
        email: registerData.email,
        firstName: registerData.firstName,
        lastName: registerData.lastName
    };

    const response = await fetch(registerUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    return response.status === 201;
}

export default registerAsync;