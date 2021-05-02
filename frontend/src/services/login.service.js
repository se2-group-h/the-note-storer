const loginUrl = 'http://trn-staging-back.us-east-2.elasticbeanstalk.com/api/login';

const loginAsync = async (username, password) => {
    const data = {username, password};

    const response = await fetch(loginUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    return response.status === 200;
}

export default loginAsync;