

# ..............................................................................................GIT......................................................................................
# git rest restetgit
alias tog='git checkout - && git stash pop'

# git rest restetgit
alias st='git stash'

# git rest restet
alias pop='git stash pop'

# git rest restet
alias r='git reset $1'

# git rest restet
alias ra='git reset --hard'

alias log='git log --pretty=oneline --abbrev-commit'

# git add
alias a='git add $1'


# git add
alias aa='git add --all'

# git checkout master
alias ma='git checkout master'


# git commiti and push to daneiel
alias cpu='git commit -m "$1" && git push daniel'



# git commiti and push to daneiel
alias gca='git commit -am "l"'

# git commit
alias co='git commit -m "$1"'

# git branch and check out
alias nb='git checkout -b $1'

function l() {
    git add .
    git commit -a -m "1"
    git push d
}


alias gc="git checkout $1"
alias gb="git branch"
alias pull="git pull upstream master"

alias m="git fetch daniel && git merge daniel/master"


alias gs="git status"

 # long listing, human-readable, sort by extension, do not show group info

git()
{
  if [ $# -gt 0 ] && [ "$1" == "diff" ] ; then
     shift
     /usr/bin/git diff --color "$@"
  else
     /usr/bin/git "$@"
  fi
}








# ..............................................................................................One......................................................................................
#!/bin/bash
echo before comment
: <<'END'
bla bla
blurfl



alias a='git add $1'
alias b="sublime ~/.bashrc"
alias c='mvn clean'
alias d='open /Users/vn0xrjh/Downloads'


function g() {

/usr/bin/open -a "/Applications/Google Chrome.app" "https://www.google.com/search?q=${*}"

}

alias h="history | grep $1"
alias i='mvn install'
alias k='sudo kill -9 $1'

function l() {
    git add .
    git commit -a -m "1"
    git push d
}



alias m="git fetch daniel && git merge daniel/master"



alias r='git reset $1'

alias s="source ~/.bashrc"



alias o='open .'
alias p='cd /Users/vn0xrjh/Projects  && ls && pwd'





END
echo after comment


# ..............................................................................................2......................................................................................
#!/bin/bash
echo before comment
: <<'END'
bla bla
blurfl





END
echo after comment





# ..............................................................................................Walmart Deve......................................................................................
# port
alias po='ps -ef|grep catalina'




alias killprocee='sudo kill "sudo lsof -t -i:$1"'

alias k='sudo kill -9 $1'



# ..............................................................................................Maven......................................................................................


alias c='mvn clean'
alias i='mvn install'
alias ci='mvn clean install'



alias c1='cd /Users/vn0xrjh/daniel/14_GUIcopymacosx/c1comehere && ls &&  pwd'

alias gesc='cd /Users/vn0xrjh/projects/gesc-services && ls &&  pwd'




# ..............................................................................................Directory......................................................................................


# alias cd='cd $1 && ls &&  pwd'

alias mc='cd /Users/vn0xrjh/projects/merchant_center && ls &&  pwd'
alias ru='cd /Users/vn0xrjh/projects/gesc-rules && ls &&  pwd'


alias ca="cd /Users/vn0xrjh/app/utils/dsc-cassandra-3.0.8/bin && ls &&  pwd"
alias cs='sudo /Users/vn0xrjh/app/utils/dsc-cassandra-2.1.14/bin/cassandra && ls &&  pwd'

alias sc='cd /Users/vn0xrjh/projects/sc_automation && ls && pwd'

alias au='cd /Users/vn0xrjh/projects1/sc_automation && ls &&  pwd'
alias so='cd /Users/vn0xrjh/app/utils/solr-6.2.1/bin && ls &&  pwd'


alias cdp="cd ~/projects/gesc-services && ls && pwd"

alias d='open /Users/vn0xrjh/Downloads'

alias doc='open /Users/vn0xrjh/Documents'
alias de='open /Users/vn0xrjh/Desktop'
alias p='cd /Users/vn0xrjh/projects  && ls && pwd'

# ..............................................................................................File......................................................................................

alias b="sublime ~/.bashrc"



# ..............................................................................................Backup......................................................................................

# copy adn fuplica thte bashrc file to my c1comehere project

cp ~/.bashrc /Users/vn0xrjh/daniel/14_GUIcopymacosx/c1comehere/bashrc
cp -r  /Users/vn0xrjh/app/utils/dsc-cassandra-2.1.14/data/data /Users/vn0xrjh/daniel/14_GUIcopymacosx/c1comehere/backupcanssandra/data
cp -r /Users/vn0xrjh/app/utils/solr-6.2.1/server/solr /Users/vn0xrjh/daniel/14_GUIcopymacosx/c1comehere/solrbkpbackup





# ..............................................................................................Folder Navigation......................................................................................


alias lsh='ls -lhXG'

#lists contents of current directory with file permisions
alias ll='ls -l -sort'

#list all directories in current directories
alias ldir='ls -l | grep ^d'



#Opens current directory in a file explorer
alias explore='open .'


#Opens current directory in a file explorer
alias o='open .'

#Opens current directory in a file explorer with super user privileges
alias suexplore='sudo open .'

#self explanatory
alias ...='cd ../../ && ls &&  pwd'

alias ....=='cd /Users/vn0xrjh && ls &&  pwd'

#earch subcategories
alias f='sudo find . -print | grep -i $1'

#earch subcategories
alias find='sudo find . -print | grep -i $1'


#We can find files in our current directory easily by setting this alias:

alias fh="find . -name $1"

alias search="ps aux | grep $1"
alias ..="cd .."


alias delete='sudo rm -rf $1'
alias remove='sudo rm -rf $1'
alias del='sudo rm -rf $1'
alias re='sudo rm -rf $1'

#insert a string to the file
alias back='cd "$OLDPWD"'
alias ls='ls -lh'


# ..............................................................................................Internet......................................................................................


   function g() {

/usr/bin/open -a "/Applications/Google Chrome.app" "https://www.google.com/search?q=${*}"

}

export -f g


function iaf() {

str=
    for i in "$@"; do
     str="$str $i"
   done
/usr/bin/open -a "/Applications/Google Chrome.app" "https://www.google.com/search?q=${str}"

}

export -f iaf





   function fm() {

/usr/bin/open -a "/Applications/Google Chrome.app" "https://www.google.com/search?q=maven%20repository%20${*}"

}

export -f fm


   function gg() {

/usr/bin/open -a "/Applications/Google Chrome.app" "https://gecgithub01.walmart.com/search?q=${*}&type=Code&utf8=✓"

}

export -f gg







# ..............................................................................................Terminal......................................................................................



alias s="source ~/.bashrc"

alias install="sudo tar -xzf $1"
alias h="history | grep $1"









function ida() {

str=

while read -r line; 
do 

#str=printf "%s\n%s\n" "$str" "$line"

#printf -v "%s\n%s" "$str" "$line" $str

#printf -v "${str}${line} %s\n" $str
str=$(printf "${str}\n\n${line}" $str)

# str="${str}"$'\n'$'\n'$'\n'$'\n'"${line}"
done

   # for i in "$@"; do 
    
#    str="$str $i"
 #   done

echo ${str}$'\n'$'\n'$'\n'$'\n' | cat - todo.txt.bak > temp && mv temp todo.txt.bak
}

export -f ida


#Cycle between three different prompts. Usage: dp N

dp () {
  if [[ $1 -eq "1" || $# -eq "0" ]]; then
    PS1="\033[01;32m$\033[00m "
  elif [[ $1 -eq "2" ]]; then
    PS1="${debian_chroot:+($debian_chroot)}\w\033[01;32m$\033[00m "
  elif [[ $1 -eq "3" ]]; then
    PS1="\033[01;32m\u@\H:${debian_chroot:+($debian_chroot)}\w\033[01;32m$\033[00m "
  fi
  return;
}

#Use it as dp N, where N is 1, 2 or 3. 


#Opens current directory in Ubuntu's Disk Usage Analyzer GUI with super user privileges in the background
alias analyze='gksudo baobab . &'

#Opens a GUI text editor in the background. Can obviously be replaced with your favorite editor
alias text='gedit &'
#Same as above with super user privileges
alias sutext='gksudo gedit &'

#Opens a file with whatever program would open by double clicking on it in a GUI file explorer
#Usage: try someDocument.doc
alias try='gnome-open'

#show aliases
alias al='echo "------------Your aliases------------";alias'
#Apply changes to aliases
alias sa='source ~/.bash_aliases;echo "Bash aliases sourced."'
#Edit Aliases
alias via='gksudo gedit ~/.bash_aliases &'

# ..............................................................................................C1 setup......................................................................................

alias solrstart='sudo /Users/vn0xrjh/app/utils/solr-6.2.1/bin/solr start'


# ..............................................................................................Automatic run......................................................................................

export PATH="~/dse/bin:$PATH"
export PATH="/Users/vn0xrjh/app/utils/dse/bin/cqlsh:$PATH"

ln -s "/Applications/Sublime Text.app/Contents/SharedSupport/bin/subl" /usr/local/bin/sublime


