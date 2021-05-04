const loginUrl = 'http://trn-staging-back.us-east-2.elasticbeanstalk.com/api/login';

const loginAsync = async (payload) => {

    const response = await fetch(loginUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    });

    return response.status === 200;
}

export default loginAsync;