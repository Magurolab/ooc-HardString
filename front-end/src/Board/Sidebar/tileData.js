import React from 'react';
import { ListItem, ListItemIcon, ListItemText } from 'material-ui/List';
import InboxIcon from 'material-ui-icons/MoveToInbox';
import DraftsIcon from 'material-ui-icons/Drafts';
import StarIcon from 'material-ui-icons/Star';
import SendIcon from 'material-ui-icons/Send';
import MailIcon from 'material-ui-icons/Mail';
import DeleteIcon from 'material-ui-icons/Delete';
import ReportIcon from 'material-ui-icons/Report';

export var mailFolderListItems = (
  <div>
      <ListItem text>
          DECK:10/10
      </ListItem>
      <ListItem text>
          MANA : 10/10
      </ListItem>
      <ListItem text>
          HEALTH: 10/10
      </ListItem>
    <ListItem button>
      <ListItemIcon>
        <InboxIcon />
      </ListItemIcon>
      <ListItemText primary="ENDTURN" />
    </ListItem>
    {/*<ListItem button>*/}
      {/*<ListItemIcon>*/}
        {/*<StarIcon />*/}
      {/*</ListItemIcon>*/}
      {/*<ListItemText primary="Starred" />*/}
    {/*</ListItem>*/}
    {/*<ListItem button>*/}
      {/*<ListItemIcon>*/}
        {/*<SendIcon />*/}
      {/*</ListItemIcon>*/}
      {/*<ListItemText primary="Send mail" />*/}
    {/*</ListItem>*/}
    {/*<ListItem button>*/}
      {/*<ListItemIcon>*/}
        {/*<DraftsIcon />*/}
      {/*</ListItemIcon>*/}
      {/*<ListItemText primary="Drafts" />*/}
    {/*</ListItem>*/}
  </div>
);

export var otherMailFolderListItems = (
  <div>
    <ListItem button>
      <ListItemIcon>
        <ReportIcon />
      </ListItemIcon>
      <ListItemText primary="Rage Quit" />
    </ListItem>
    {/*<ListItem button>*/}
      {/*<ListItemIcon>*/}
        {/*<DeleteIcon />*/}
      {/*</ListItemIcon>*/}
      {/*<ListItemText primary="Trash" />*/}
    {/*</ListItem>*/}
    {/*<ListItem button>*/}
      {/*<ListItemIcon>*/}
        {/*<ReportIcon />*/}
      {/*</ListItemIcon>*/}
      {/*<ListItemText primary="Spam" />*/}
    {/*</ListItem>*/}
  </div>
);