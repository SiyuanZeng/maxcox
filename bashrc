#.........................................................................................Directory......

alias mc='cd /Users/vn0xrjh/projects/merchant_center'








# copy adn fuplica thte bashrc file to my c1comehere project

cp ~/.bashrc /Users/vn0xrjh/daniel/14_GUIcopymacosx/c1comehere/bashrc


alias killprocee='sudo kill "sudo lsof -t -i:$1"'

alias kill='sudo kill -9 $1'

alias sc='cd /Users/vn0xrjh/projects/sc_automation'






# ..............................................................................................GIT......................................................................................

# git rest restet
alias r='git reset $1'

# git add
alias ad='git add $1'


# git checkout master
alias gitm='git checkout master'


# git commiti and push to daneiel
alias gitcp='git commit -m "$1" && git push daniel'


# git commit
alias gitco='git commit -m "$1"'

alias gitc='git checkout'

# git branch and check out
alias gitbc='git branch $1 && git checkout $1'

function l() {
    git add .
    git commit -a -m "1"
    git push d
}












alias c1='cd /Users/vn0xrjh/daniel/14_GUIcopymacosx/c1comehere'

alias gesc='cd /Users/vn0xrjh/projects/gesc-services'


#earch subcategories
alias find='sudo find . -print | grep -i $1'


alias delete='sudo rm -rf $1'
alias remove='sudo rm -rf $1'
alias del='sudo rm rf $1'
alias rm='sudo rm -rf $1'

ln -s "/Applications/Sublime Text.app/Contents/SharedSupport/bin/subl" /usr/local/bin/sublime

#insert a string to the file
alias back='cd "$OLDPWD"'
alias ..="cd .."

function ida() {

str=

while read -r line; 
do 

#str=printf "%s\n%s\n" "$str" "$line"

#printf -v "%s\n%s" "$str" "$line" $str

#printf -v "${str}${line} %s\n" $str
str=$(printf "${str}\n\n${line}" $str)

#	str="${str}"$'\n'$'\n'$'\n'$'\n'"${line}"
done

   # for i in "$@"; do 
    
#    str="$str $i"
 #   done

echo ${str}$'\n'$'\n'$'\n'$'\n' | cat - todo.txt.bak > temp && mv temp todo.txt.bak
}

export -f ida

#We can find files in our current directory easily by setting this alias:

alias fhere="find . -name "


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

alias lsh='ls -lhXG'

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


#Opens current directory in a file explorer
alias explore='open .'

#Opens current directory in a file explorer with super user privileges
alias suexplore='sudo open .'

#Opens current directory in Ubuntu's Disk Usage Analyzer GUI with super user privileges in the background
alias analyze='gksudo baobab . &'

#Opens a GUI text editor in the background. Can obviously be replaced with your favorite editor
alias text='gedit &'
#Same as above with super user privileges
alias sutext='gksudo gedit &'

#Opens a file with whatever program would open by double clicking on it in a GUI file explorer
#Usage: try someDocument.doc
alias try='gnome-open'

#lists contents of current directory with file permisions
alias ll='ls -l -sort'

#list all directories in current directories
alias ldir='ls -l | grep ^d'

#self explanatory
alias ...='cd ../../'

#show aliases
alias a='echo "------------Your aliases------------";alias'
#Apply changes to aliases
alias sa='source ~/.bash_aliases;echo "Bash aliases sourced."'
#Edit Aliases
alias via='gksudo gedit ~/.bash_aliases &'


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

alias search="ps aux | grep $1"

alias install="sudo tar -xzf $1"
alias solrd='cd /Users/vn0xrjh/app/utils/solr-6.2.1/bin'

alias solrstart='sudo /Users/vn0xrjh/app/utils/solr-6.2.1/bin/solr start'

alias cdp="cd ~/projects/gesc-services"
alias h="history | grep $1"
alias ck="git checkout $1"
alias gitb="git branch"
alias pull="git pull upstream master"
alias gits="git status"
alias dse="cd /Users/vn0xrjh/app/utils/dsc-cassandra-3.0.8/bin"
alias cassandrastart='sudo /Users/vn0xrjh/app/utils/dsc-cassandra-2.1.14/bin/cassandra'

alias b="vim ~/.bashrc"
alias s="source ~/.bashrc"
export PATH="~/dse/bin:$PATH"
export PATH="/Users/vn0xrjh/app/utils/dse/bin/cqlsh:$PATH"
