url="https://api.github.com/repos/tarek360/emptyapp/pulls/$TRAVIS_PULL_REQUEST/merge"
curl -H 'Host: api.github.com' -H 'Content-Type: application/json' -H "Authorization: token $GITHUB_SECRET_TOKEN" --data-binary '{"commit_title": "Mergo title","commit_message":"Mergo message"}' -X PUT --compressed $url
echo $url
echo $GITHUB_SECRET_TOKEN