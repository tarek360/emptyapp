url="https://api.github.com/repos/tarek360/emptyapp/pulls/$TRAVIS_PULL_REQUEST/merge?access_token=ac7574160bed78c47ed5ed581e613eeee824d20f"
curl -H 'Host: api.github.com' -H 'Content-Type: application/json' --data-binary '{"commit_title": "Mergo title","commit_message":"Mergo message"}' -X PUT --compressed $url
echo $url